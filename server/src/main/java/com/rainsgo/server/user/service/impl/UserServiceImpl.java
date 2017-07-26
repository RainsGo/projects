package com.rainsgo.server.user.service.impl;

import com.rainsgo.server.user.dao.UserDao;
import com.rainsgo.server.user.model.User;
import com.rainsgo.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findByUsername(name);
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Long deleteUser(String id) {
        return userDao.deleteUser(id);
    }
}
