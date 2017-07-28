package com.rainsgo.server.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rain on 17-7-13.
 */
@RestController
@RequestMapping("/api/test")
public class HelloRestApi {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello World!";
    }
}
