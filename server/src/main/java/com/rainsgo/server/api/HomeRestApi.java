package com.rainsgo.server.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HomeRestApi {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ApiResultBody home(){
        return new ApiResultBody("Welcom to RainsGo web site!");
    }
}
