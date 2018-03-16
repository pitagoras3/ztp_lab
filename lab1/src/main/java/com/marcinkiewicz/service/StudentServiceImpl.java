package com.marcinkiewicz.service;

import com.marcinkiewicz.dao.StudentDAO;
import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    public StudentServiceImpl(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    private StudentDAO studentDAO;


    @Override
    public void createNewStudent(Student newStudent) {
        studentDAO.createNewStudent(newStudent);
    }

    @Override
    public List<Student> readAllStudents() {
        return studentDAO.readAllStudents();
    }

    @Override
    public Student readStudentById(int studentId) {
        return studentDAO.readStudentById(studentId);
    }

    @Override
    public void updateStudentById(int studentId, Student updatedStudent) {
        studentDAO.updateStudentById(studentId, updatedStudent);
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentDAO.deleteStudentById(studentId);
    }




}
