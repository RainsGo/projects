package com.rainsgo.server.user.service;

import com.rainsgo.server.user.model.Role;

import java.util.List;

public interface RoleService {

    /**
     * 获取角色列表
     */
    List<Role> findAll();

    /**
     * 根据角色ID获取Role
     */
    Role findById(String id);

    /**
     * 根据角色名获取Role
     */
    Role findByName(String name);

    /**
     * 新增Role
     */
    Role addRole(Role role);

    /**
     * 更新Role
     */
    Role updateRole(Role role);

    /**
     * 删除Role
     */
    Long deleteRole(String id);

    /**
     * 删除Role
     */
}
