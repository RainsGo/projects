package com.rainsgo.server.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rain on 17-7-13.
 */
@RestController
public class HelloRestApi {

    @RequestMapping("/hello")
    public String index(){
        return "Hello World!";
    }
}
