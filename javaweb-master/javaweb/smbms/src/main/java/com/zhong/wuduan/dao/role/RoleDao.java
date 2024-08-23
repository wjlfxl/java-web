package com.zhong.wuduan.dao.role;

import com.zhong.wuduan.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {

    /**
     * 获取用户角色列表
     *
     * @param connection 数据库连接对象
     * @return 返回用户角色列表
     * @throws SQLException SQL 执行出错时会抛出异常
     */
    List<Role> getUserRoleList(Connection connection) throws SQLException;
}
