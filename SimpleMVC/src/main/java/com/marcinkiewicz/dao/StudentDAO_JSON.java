package com.marcinkiewicz.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO_JSON implements StudentDAO{


    @Override
    public String getAllStudents() {
        return "List of all students from JSON.";
    }
}
