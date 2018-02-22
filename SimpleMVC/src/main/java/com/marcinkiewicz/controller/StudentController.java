package com.marcinkiewicz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String listAllStudents(){
        return "List of all students";
    }

}
