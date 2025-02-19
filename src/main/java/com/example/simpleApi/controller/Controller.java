package com.example.simpleApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    @RequestMapping(value="/",method=RequestMethod.GET)
    public @ResponseBody
    String defaultRoute(){
        return "default root";
    }

    @RequestMapping(value="/helloworld", method= RequestMethod.GET)
    public @ResponseBody
    String helloworld(){
        return "hello world";
    }
}
