package com.marcinkiewicz.dao;

import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;

import java.util.List;

public interface StudentDAO {
    void createNewStudent(Student newStudent);
    List<Student> readAllStudents();
    Student readStudentById(int studentId);
    void updateStudentById(int studentId, Student updatedStudent);
    void deleteStudentById(int studentId);
}
