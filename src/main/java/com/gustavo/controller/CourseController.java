package com.gustavo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CourseController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

}
