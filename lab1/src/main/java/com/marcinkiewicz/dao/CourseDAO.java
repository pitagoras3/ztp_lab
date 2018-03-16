package com.marcinkiewicz.dao;

import com.marcinkiewicz.model.Course;

public interface CourseDAO {
    void createNewCourseToStudent(Integer studentId, Course newCourse);
    void deleteCourseFromStudent(int courseId);
}
