package com.marcinkiewicz.controller;

import com.marcinkiewicz.dao.StudentDAO;
import com.marcinkiewicz.dao.StudentDAO_JSON;
import com.marcinkiewicz.service.StudentService;
import com.marcinkiewicz.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentDAO studentDAO;

    @Autowired
    private StudentService studentService;

    public StudentController(){
        this.studentDAO = new StudentDAO_JSON();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String listAllStudents(){
        return studentService.getAllStudents();
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }
}
