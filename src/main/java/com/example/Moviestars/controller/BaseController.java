package com.example.Moviestars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/thieu")
    public String sayThieu(){
        return "Hello Thieu";
    }
}
