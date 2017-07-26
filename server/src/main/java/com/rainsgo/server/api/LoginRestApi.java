package com.rainsgo.server.api;

import com.rainsgo.server.user.model.User;
import com.rainsgo.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rain on 17-7-18.
 */
@RestController
public class LoginRestApi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/login/check/{username}/{password}", method = RequestMethod.GET)
    public String loginCheck(HttpServletRequest request,
                             @PathVariable("username") String userName,
                             @PathVariable("password") String password){
        /*
        User user = userService.findUserByNameAndPwd(userName, password);

        if(user != null){
            LoginLog log = new LoginLog();
            log.setLoginIp(request.getLocalAddr());
            log.setUserId(user.getId());
            request.getSession().setAttribute("user", user);
            return "success";
        }else{
            return "error: "+"用户名或密码错误.";
        }
        */
        return "";
    }

    @RequestMapping(value = "/api/login/register", method = RequestMethod.POST)
    public User LoginRegister(@RequestBody User user){
        return userService.addUser(user);
    }
}
