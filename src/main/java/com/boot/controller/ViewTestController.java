package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangguanru
 * @date 2022-01-27
 */

@Controller
public class ViewTestController {

    @GetMapping("/test")
    public String test(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","你好，zyr");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
