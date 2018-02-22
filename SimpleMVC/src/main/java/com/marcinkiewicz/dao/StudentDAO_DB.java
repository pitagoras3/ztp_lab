package com.marcinkiewicz.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO_DB implements StudentDAO {

    @Override
    public String getAllStudents() {
        return "All students from DB.";
    }
}
