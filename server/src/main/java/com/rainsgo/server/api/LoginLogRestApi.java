package com.rainsgo.server.api;

import com.rainsgo.server.log.model.LoginLog;
import com.rainsgo.server.log.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogRestApi {

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping(value = "/api/loginlog", method = RequestMethod.GET)
    public LoginLog findByUserId(@RequestParam(value = "userId", required = true) Long userId){
        return loginLogService.findLogByUserId(userId);
    }
}
