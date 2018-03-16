package com.marcinkiewicz.dao;

import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;

import java.util.List;

public class CourseDAO_JSON extends DAO_JSON implements CourseDAO {

    @Override
    public void createNewCourseToStudent(Integer studentId, Course newCourse) {
        newCourse.setId(getNextCourseId(studentId));

        List<Student> allStudents = readAllStudents();
        for(Student student : allStudents){
            if(student.getId() == studentId){
                student.getCourseList().add(newCourse);
            }
        }

        saveNewListOfStudents(allStudents);
    }

    @Override
    public void deleteCourseFromStudent(int courseId) {

        List<Student> allStudents = readAllStudents();

        for(Student student : allStudents){
            for(int i = 0; i < student.getCourseList().size(); i++){
                if(student.getCourseList().get(i).getId() == courseId){
                    student.getCourseList().remove(i);
                }
            }
        }

        saveNewListOfStudents(allStudents);
    }


}
