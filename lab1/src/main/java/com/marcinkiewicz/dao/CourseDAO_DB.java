package com.marcinkiewicz.dao;

import com.marcinkiewicz.model.Course;

public class CourseDAO_DB extends DAO_DB implements CourseDAO{

    @Override
    public void createNewCourseToStudent(Integer id, Course course) {
        String createNewCourse = String.format("INSERT INTO `university`.`student_courses` (`student_id`, `title`) VALUES ('%d', '%s');", id, course.getTitle());
        executeUpdate(createNewCourse);
    }

    @Override
    public void deleteCourseFromStudent(int courseId) {
        String deleteQuery = String.format("DELETE FROM `university`.`student_courses` WHERE `course_id`='%d';", courseId);
        executeUpdate(deleteQuery);
    }

}
