package com.zhong.wuduan.dao.role;


import com.zhong.wuduan.dao.BaseDao;
import com.zhong.wuduan.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    // 获取用户角色列表
    public List<Role> getUserRoleList(Connection connection) throws SQLException {

        ResultSet rs = null;
        PreparedStatement pstm = null;
        ArrayList<Role> roleList = new ArrayList<Role>();

        if (connection != null) {
            String sql = "SELECT * FROM smbms_role";
            Object[] params = {};
            rs = (ResultSet) BaseDao.execute(connection,pstm,rs,sql,params);

            // 遍历查询到的结果集
            while (rs.next()) {
                Role _role = new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleCode(rs.getString("roleCode"));
                _role.setRoleName(rs.getString("roleName"));

                roleList.add(_role);
            }
            BaseDao.closeResource(null, rs, pstm);
        }

        return roleList;
    }
}
