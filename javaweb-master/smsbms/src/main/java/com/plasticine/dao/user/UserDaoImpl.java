package com.plasticine.dao.user;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.util.StringUtils;
import com.plasticine.dao.BaseDao;
import com.plasticine.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    // 得到登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "SELECT * FROM smbms_user WHERE userCode=?";
            Object[] params = {userCode};

            rs = (ResultSet) BaseDao.execute(connection, sql, params, rs, pstm);

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
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(connection, rs, pstm);
        }

        return user;
    }

    // 修改当前用户的密码
    public boolean updatePwd(Connection connection, int id, String password) {

        PreparedStatement pstm = null;
        boolean isSucceed = false;

        if (connection != null) {
            String sql = "UPDATE smbms_user SET userPassword=? WHERE id=?";
            Object[] params = {password, id};

            try {
                // 受影响的行数大于0才是修改成功
                int affectedRows = BaseDao.execute(connection, sql, params, pstm);
                if (affectedRows > 0)
                    isSucceed = true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                BaseDao.closeResource(connection, null, pstm);
            }
        }

        return isSucceed;
    }

    // 根据用户名或角色 id 查询用户总数
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            ArrayList<Object> paramsList = new ArrayList<Object>();

            // 根据条件构造 SQL 语句
            sql.append("SELECT COUNT(1) AS count\n" +
                    "FROM smbms_user u,\n" +
                    "     smbms_role r\n" +
                    "WHERE u.userRole = r.id");

            // 有传入用户名 -- AND u.userName LIKE '%系统%'
            if (!StringUtils.isNullOrEmpty(username)) {
                sql.append(" AND u.userName LIKE ?");
                // 构造参数列表
                paramsList.add("%" + username + "%");
            }

            // 有传入用户角色
            if (userRole > 0) {
                sql.append(" AND r.id=?");
                // 构造参数列表
                paramsList.add(userRole);
            }

            // 把 List 转换为数组
            Object[] params = paramsList.toArray();

            // 打印完整的 SQL
            System.out.println("SQL: UserDaoImpl.getUserCount --> " + sql.toString());


            rs = (ResultSet) BaseDao.execute(connection, sql.toString(), params, rs, pstm);

            // 获取查询到的结果
            if (rs.next()) {
                count = rs.getInt("count");
            }
            BaseDao.closeResource(null, rs, pstm);
        }

        return count;
    }

    // 通过条件查询用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = null;

        if (connection != null) {
            // ==================这一部分与获取用户总数一致==================
            StringBuffer sql = new StringBuffer();
            ArrayList<Object> paramsList = new ArrayList<Object>();
            sql.append("SELECT * FROM smbms_user u, smbms_role r WHERE u.userRole=r.id");

            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" AND u.userName=?");
                paramsList.add("%" + userName + "%");
            }

            if (userRole > 0) {
                sql.append(" AND r.id=?");
                paramsList.add(userRole);
            }
            // ==================这一部分与获取用户总数一致==================
            // 实现分页功能 -- LIMIT startIndex, pageSize 比如第1页就是0,5 第2页就是5,5 第3页就是10,5
            sql.append(" ORDER BY u.creationDate DESC LIMIT ?,?");

            // startIndex 应当等于(第i页 - 1) * pageSize
            int startIndex = (currentPageNo - 1) * pageSize;

            // 把 startIndex 和 pageSize 加入到参数列表中
            paramsList.add(startIndex);
            paramsList.add(pageSize);

            // 把参数列表转成数组
            Object[] params = paramsList.toArray();
            System.out.println("SQL: UserDaoImpl.getUserList --> " + sql);
            rs = (ResultSet) BaseDao.execute(connection, sql.toString(), params, rs, pstm);

            // 遍历查询到的用户列表，加入到结果列表中
            userList = new ArrayList<User>();
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
                _user.setCreatedBy(rs.getInt("createdBy"));
                _user.setCreationDate(rs.getTimestamp("creationDate"));
                _user.setModifyBy(rs.getInt("modifyBy"));
                _user.setModifyDate(rs.getTimestamp("modifyDate"));
                // 加入到结果列表中
                userList.add(_user);
            }
            BaseDao.closeResource(null, rs, pstm);
        }

        return userList;
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
            updateRows = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null, null, pstm);
        }

        return updateRows;
    }

    // 删除用户
    public int delete(Connection connection, Integer userId) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;

        if (connection != null) {
            String sql = "DELETE FROM smbms_user WHERE id=?";
            Object[] params = {userId};

            updateRows = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null, null, pstm);
        }

        return updateRows;
    }

    // 根据 id 查询用户
    public User getUserById(Connection connection, Integer userId) throws SQLException {
        PreparedStatement pstm = null;
        PreparedStatement pstmRoleName = null;
        ResultSet rs = null;
        ResultSet rsRoleName = null;
        User user = null;

        if (connection != null) {
            String sql = "SELECT * FROM smbms_user WHERE id=?"; // 查询用户
            String queryRoleNameSql = "SELECT roleName FROM smbms_role WHERE id=?"; // 根据用户的 userRole 查询用户类型名字
            Object[] params = {userId};

            // 查询用户
            rs = (ResultSet) BaseDao.execute(connection, sql, params, rs, pstm);

            if (rs.next()) {

                // 根据查询到的用户中的 userRole 去查询用户类型名字
                Object[] roleNameParams = {rs.getInt("userRole")};
                String userRoleName = null;
                rsRoleName = (ResultSet) BaseDao.execute(connection, queryRoleNameSql, roleNameParams, rsRoleName, pstmRoleName);
                if (rsRoleName.next()) {
                    userRoleName = rsRoleName.getString("roleName");
                } else {
                    userRoleName = "无";
                }

                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRoleName(userRoleName);
            }


            BaseDao.closeResource(connection, rs, pstm);
        }
        return user;
    }

    public int modifyUser(Connection connection, User user) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;

        if (connection != null && user != null) {
            String sql = "UPDATE smbms_user SET userName=?, gender=?, birthday=?, phone=?, address=?, userRole=? WHERE id=?";
            Object[] params = {user.getUserName(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getUserRole(), user.getId()};

            updateRows = BaseDao.execute(connection, sql, params, pstm);
        }

        return updateRows;
    }
}
