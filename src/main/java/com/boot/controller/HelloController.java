package com.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author wangguanru
 * @date 2022-01-24
 */
@RestController
public class HelloController {

    @RequestMapping("/bug.jpg")
    public String hello(){
        //request
        return "aaaa";
    }

    // @RequestMapping(value= "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

    // @RequestMapping(value= "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }
}
