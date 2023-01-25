package com.java.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class TestController {
    @RequestMapping("/test")
    public String firstHandler(){
        int a =30;
        int b =40;
        int c =50;
        return "Just For Testing Sum of a,b and c is " + (a + b + c);
    }
}
