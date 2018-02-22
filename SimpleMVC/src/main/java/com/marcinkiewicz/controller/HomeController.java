package com.marcinkiewicz.controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String homeView(){
        return "Home";
    }

}
