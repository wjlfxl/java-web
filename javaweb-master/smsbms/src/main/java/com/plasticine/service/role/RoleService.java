package com.plasticine.service.role;

import com.plasticine.pojo.Role;

import java.util.List;

public interface RoleService {

    /**
     * 获取用户角色列表
     */
    List<Role> getUserRoleList();
}
