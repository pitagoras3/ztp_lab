package com.marcinkiewicz.service;

import com.marcinkiewicz.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource(name="studentDAO_JSON")
    private StudentDAO studentDAO;

    @Override
    public String getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
