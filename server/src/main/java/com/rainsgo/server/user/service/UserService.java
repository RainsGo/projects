package com.rainsgo.server.user.service;

import com.rainsgo.server.user.model.User;

import java.util.List;

/**
 * Created by rain on 17-7-16.
 */
public interface UserService {

    /**
     * 获取用户列表
     */
    List<User> findAllUser();

    /**
     * 根据用户ID获取User
     */
    User findUserById(String id);

    /**
     * 根据用户名获取User
     */
    User findUserByName(String name);

    /**
     * 新增User
     */
    User addUser(User user);

    /**
     * 更新User
     */
    User updateUser(User user);

    /**
     * 删除User
     */
    Long deleteUser(String id);
}
