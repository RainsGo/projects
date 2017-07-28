package com.rainsgo.server.user.service.impl;

import com.rainsgo.server.user.dao.RoleDao;
import com.rainsgo.server.user.model.Permission;
import com.rainsgo.server.user.model.Role;
import com.rainsgo.server.user.service.RoleService;
import com.rainsgo.server.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public boolean addRole(Role role) {
        if(roleDao.addRole(role)<0){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateRole(Role role) {
        if(roleDao.updateRole(role)<0){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteRole(String name) {
        if(roleDao.deleteRole(name) < 0){
            return false;
        }
        return true;
    }

    @Override
    public List<Role> findByUserId(String userId) {
        return roleDao.findByUserId(userId);
    }
}
