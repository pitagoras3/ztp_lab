package com.marcinkiewicz.service;

import com.marcinkiewicz.dao.StudentDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO)

    @Override
    public String getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
