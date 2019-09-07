package com.syk.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shaoyikun
 * @Date: 2019-09-07
 * @Description:
 **/
@RestController
public class HelloWorldController {
    @GetMapping(value = "index")
    public String helloWorld() {
        return "Hello World!";
    }
}
