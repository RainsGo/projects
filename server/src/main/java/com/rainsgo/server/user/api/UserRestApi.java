package com.rainsgo.server.user.api;

import com.rainsgo.server.user.model.User;
import com.rainsgo.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestApi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/find/{username}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable("username") String username){
        return userService.findByName(username);
    }
}
