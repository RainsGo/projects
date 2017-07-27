package com.rainsgo.server.api;

import com.rainsgo.server.log.model.LoginLog;
import com.rainsgo.server.log.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs/login")
public class LoginLogRestApi {

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping(value = "/find/{userid}", method = RequestMethod.GET)
    public LoginLog findByUserId(@PathVariable("userid") Long userId){
        return loginLogService.findLogByUserId(userId);
    }
}
