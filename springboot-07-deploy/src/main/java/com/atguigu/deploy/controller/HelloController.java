package com.atguigu.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloController {

    //mac上热部署的快捷键是command+，
    @GetMapping("/abc")
    public String hello(){
        return "hello";
    }
}
