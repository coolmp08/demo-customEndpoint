package com.devSense.customEndpoint.demo_CustomEndpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping(value = "/")
    public String display(){
        return "Hello There !";
    }
}
