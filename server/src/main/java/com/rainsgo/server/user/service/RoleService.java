package com.rainsgo.server.user.service;

import com.rainsgo.server.user.model.Permission;
import com.rainsgo.server.user.model.Role;

import java.util.List;

public interface RoleService {

    /**
     * 获取角色列表
     */
    List<Role> findAll();

    /**
     * 根据角色名获取Role
     */
    Role findByName(String name);

    /**
     * 新增Role
     */
    boolean addRole(Role role);

    /**
     * 更新Role
     */
    boolean updateRole(Role role);

    /**
     * 删除Role
     */
    boolean deleteRole(String name);

    /**
     * 根据UserId获取角色列表
     */
    List<Role> findByUserId(String userId);
}
