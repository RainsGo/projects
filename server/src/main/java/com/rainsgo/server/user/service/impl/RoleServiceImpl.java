package com.rainsgo.server.user.service.impl;

import com.rainsgo.server.user.dao.RoleDao;
import com.rainsgo.server.user.model.Role;
import com.rainsgo.server.user.service.RoleService;
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
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public Long deleteRole(String id) {
        return roleDao.deleteRole(id);
    }
}
