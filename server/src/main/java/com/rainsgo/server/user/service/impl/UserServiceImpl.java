package com.rainsgo.server.user.service.impl;

import com.rainsgo.server.user.dao.UserDao;
import com.rainsgo.server.user.model.User;
import com.rainsgo.server.user.service.UserService;
import com.rainsgo.server.utils.IdUtils;
import com.rainsgo.server.utils.TimeUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public boolean addUser(User user) {
        user.setId(IdUtils.generateUUID());
        user.setLastPasswordResetDate(TimeUtils.generateTimestampByNow());
        if(userDao.addUser(user)<0){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if(userDao.updateUser(user)<0){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        if(userDao.deleteUser(id)<0){
            return false;
        }
        return true;
    }
}
