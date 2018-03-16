package com.marcinkiewicz.service;

import com.marcinkiewicz.dao.CourseDAO;
import com.marcinkiewicz.model.Course;

public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }

    @Override
    public void createNewCourseToStudent(Integer studentId, Course newCourse) {
        courseDAO.createNewCourseToStudent(studentId, newCourse);
    }

    @Override
    public void deleteCourseFromStudent(int courseId) {
        courseDAO.deleteCourseFromStudent(courseId);
    }

}
