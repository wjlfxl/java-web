package com.zhong.wuduan.dao.user;

import com.mysql.jdbc.StringUtils;
import com.zhong.wuduan.dao.BaseDao;
import com.zhong.wuduan.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/21 0:30
 */
public class UserDaoImp implements UserDao{
    // 删除用户
    public int delete(Connection connection, Integer userId) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;

        if (connection != null) {
            String sql = "DELETE FROM smbms_user WHERE id=?";
            Object[] params = {userId};

            updateRows = BaseDao.execute(connection,pstm,sql,params);
            BaseDao.closeResource(null, null, pstm);
        }

        return updateRows;
    }
    // 新增用户
    public int add(Connection connection, User user) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "INSERT INTO smbms_user(userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            // 构造参数
            Object[] params = {
                    user.getUserCode(), user.getUserName(), user.getUserPassword(), user.getGender(),
                    user.getBirthday(), user.getPhone(), user.getAddress(), user.getUserRole(),
                    user.getCreatedBy(), user.getCreationDate()
            };
            updateRows = BaseDao.execute(connection,pstm,sql,params);
            BaseDao.closeResource(null, null, pstm);
        }

        return updateRows;
    }
    @Override
    public List<User> getUserlist(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = null;

        if (connection != null) {
            // ==================这一部分与获取用户总数一致==================
            StringBuffer sql = new StringBuffer();
            ArrayList<Object> paramsList = new ArrayList<>();
            sql.append("SELECT u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");


            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                paramsList.add("%" + userName + "%");
            }

            if (userRole > 0) {
                sql.append(" and u.userRole= ?");
                paramsList.add(userRole);
            }
            // ==================这一部分与获取用户总数一致==================
            // 实现分页功能 -- LIMIT startIndex, pageSize 比如第1页就是0,5 第2页就是5,5 第3页就是10,5
            //在数据库中，分页使用  limit startIndex,pageSize;

            sql.append(" ORDER BY u.creationDate DESC LIMIT ?,?");

            // startIndex 应当等于(第i页 - 1) * pageSize
            int startIndex = (currentPageNo - 1) * pageSize;

            // 把 startIndex 和 pageSize 加入到参数列表中
            paramsList.add(startIndex);
            paramsList.add(pageSize);

            // 把参数列表转成数组
            Object[] params = paramsList.toArray();
            System.out.println("SQL: UserDaoImpl.getUserList --> " + sql);
            rs =  BaseDao.execute(connection, pstm,rs,sql.toString(),params);

            // 遍历查询到的用户列表，加入到结果列表中
            userList = new ArrayList<>();
            while (rs.next()) {
                // 实例化一个 User 对象，并给相关属性赋值
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setUserPassword(rs.getString("userPassword"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setAddress(rs.getString("address"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setCreatedBy(rs.getInt("createBy"));
                _user.setCreationDate(rs.getTimestamp("creationDate"));
                _user.setModifyBy(rs.getInt("modifyBy"));
                _user.setModifyDate(rs.getTimestamp("modifyDate"));
                _user.setAge(rs.getInt("age"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                // 加入到结果列表中
                userList.add(_user);
            }
            BaseDao.closeResource(null, rs, pstm);
        }

        return userList;
    }
@Test
public void test1() throws SQLException {
    UserDaoImp userDaoImp = new UserDaoImp();

    List<User> userlist = userDaoImp.getUserlist(BaseDao.getConnection(), "", 2, 1, 2);
    for (User user : userlist) {
        System.out.println(user);
    }
}
    //根据用户名或者角色查询
    @Override
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {

        PreparedStatement pstm=null;
        ResultSet rs=null;

        int count=0;
        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole=r.id");
            ArrayList<Object> list = new ArrayList<>();//存放我们的参数

            if(!StringUtils.isNullOrEmpty(username)){
                sql.append(" and u.userName list ?");
                list.add("%"+username+"%");//index:0
            }
            if(userRole>0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);//index:1

            }
            //怎么把list转换为数组
            Object[] params = list.toArray();

            System.out.println("UserDaoImpl-->getUserCount:"+sql.toString());


            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

         if(rs.next()){
              count = rs.getInt("count");//从结果集中获取最终的数据

         }
         BaseDao.closeResource(null,rs,pstm);
        }
        return count;
    }

    @Override
    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        PreparedStatement pstm=null;
        int execute=0;
        if (connection!=null) {
            String sql="update smbms_user set userPassword=? where id=?";
            Object[] params={password,id};
            execute = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, null, pstm);
        } 
        return execute;

    }

    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        User user=null;
        String sql="select * from smbms_user where userCode=?";
        Object[] params={userCode};
        if(connection!=null) {

            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createBy"));
                user.setCreationDate(rs.getDate("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getDate("modifyDate"));
            }
            BaseDao.closeResource(null, rs, pstm);
        }

        return user;

    }
}
