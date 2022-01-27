package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangguanru
 * @date 2022-01-24
 */

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功了...");
        request.setAttribute("code",200);
        return "forward:/success";  //转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code")Integer code,
                                       HttpServletRequest request){

        Object msg1=request.getAttribute("msg");
        Map<String,Object> map=new HashMap<>();
        map.put("reqMethod_msg",msg1);
        map.put("annotation_msg",msg);
        return map;
    }

    //1.语法 /cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认禁用了矩阵变量的功能
    // 手动开启:原理。对于路径的处理 urlPathHelper进行解析
    //           removeSemicolonContent(移除分号内容)支持矩阵变量的
    @GetMapping("/cars/sell")
    public Map carSell(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand){
        Map<String,Object> map=new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        return map;
    }

}
