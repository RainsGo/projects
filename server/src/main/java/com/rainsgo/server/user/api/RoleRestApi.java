package com.rainsgo.server.user.api;

import com.rainsgo.server.user.model.Role;
import com.rainsgo.server.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestApi {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<Role> findAll(){
        return roleService.findAll();
    }

    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public Role findOneRole(@PathVariable("name") String name){
        return roleService.findByName(name);
    }
}
