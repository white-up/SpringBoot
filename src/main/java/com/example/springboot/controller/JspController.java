package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/work")
public class JspController {
    @PostMapping("/example1")
    public String work1(){
        return "test";
    }
    @GetMapping("/example2/exam")
    public String example2(){
        return "exam";
    }
    @GetMapping("/example2/scriptlet")
    public String example2scriptlet(){
        return "scriptlet";
    }
    @GetMapping("/example2/include")
    public String example2include(){return "include";}
    @GetMapping("/example2/my")
    public String example2my(){return "My1";}
    @GetMapping("/example2/forward")
    public String example2forward(){return "forward";}


}