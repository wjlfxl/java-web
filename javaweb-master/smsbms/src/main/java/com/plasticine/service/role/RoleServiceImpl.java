package com.plasticine.service.role;

import com.plasticine.dao.BaseDao;
import com.plasticine.dao.role.RoleDaoImpl;
import com.plasticine.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDaoImpl roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    // 获取用户角色列表
    public List<Role> getUserRoleList() {
        Connection connection = BaseDao.getConnection();
        List<Role> userRoleList = null;

        try {
            userRoleList = roleDao.getUserRoleList(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return userRoleList;
    }

    /**
     * 测试获取用户角色列表api
     */
    @Test
    public void testGetUserRoleList() {
        List<Role> userRoleList = getUserRoleList();
        for (Role role : userRoleList) {
            System.out.println(role.getRoleName());
        }
    }
}
