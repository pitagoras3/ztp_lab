package com.marcinkiewicz.service;

import com.marcinkiewicz.model.Course;

public interface CourseService {
    void createNewCourseToStudent(Integer studentId, Course newCourse);
    void deleteCourseFromStudent(int courseId);
}
