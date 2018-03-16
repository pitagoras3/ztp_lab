package com.marcinkiewicz.dao;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO_JSON extends DAO_JSON implements StudentDAO {

    @Override
    public void createNewStudent(Student newStudent) {
        newStudent.setId(getNextStudentId());

        if(isFileEmpty()){
            List<Student> oneStudentList = new ArrayList<>();
            oneStudentList.add(newStudent);

            saveNewListOfStudents(oneStudentList);
        }
        else{
            List<Student> allStudents = readAllStudents();
            allStudents.add(newStudent);
            saveNewListOfStudents(allStudents);
        }

    }

    @Override
    public List<Student> readAllStudents() {
        return super.readAllStudents();
    }

    @Override
    public Student readStudentById(int studentId) {
        List<Student> allStudents = readAllStudents();
        Student searchedStudent = null;

        for(Student student : allStudents){
            if(student.getId() == studentId){
                searchedStudent = student;
            }
        }
        return searchedStudent;
    }

    @Override
    public void updateStudentById(int studentId, Student updatedStudent) {

        List<Student> allStudents = readAllStudents();

        for(Student student : allStudents){
            if(student.getId() == studentId){
                student.setName(updatedStudent.getName());
                student.setSurname(updatedStudent.getSurname());
            }
        }

        saveNewListOfStudents(allStudents);
    }

    @Override
    public void deleteStudentById(int studentId) {
        List<Student> allStudents = readAllStudents();

        for(int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getId() == studentId) {
                allStudents.remove(i);
            }
        }

        saveNewListOfStudents(allStudents);
    }





}