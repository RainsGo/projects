package com.rainsgo.server.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestApi {

    @RequestMapping(value = "/")
    public String home(){
        return "Welcom to RainsGo web site!";
    }
}
