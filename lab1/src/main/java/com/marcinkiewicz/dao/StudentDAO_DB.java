package com.marcinkiewicz.dao;

import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO_DB extends DAO_DB implements StudentDAO {



    @Override
    public void createNewStudent(Student newStudent) {
        String createNewStudentQuery = String.format("INSERT INTO `university`.`student` (`name`, `surname`) VALUES ('%s', '%s');", newStudent.getName(), newStudent.getSurname());
        executeUpdate(createNewStudentQuery);
    }



    @Override
    public List<Student> readAllStudents() {
        String query = "SELECT * FROM STUDENT";
        ArrayList<Student> resultList = new ArrayList<>();

        openConnection();

        try{
            ResultSet resultSet = executeQuery(query);

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                resultList.add(new Student(id, name, surname));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        closeConnection();

        return resultList;
    }

    @Override
    public Student readStudentById(int id) {
        String query = String.format("SELECT * FROM university.student s LEFT JOIN university.student_courses c ON s.id = c.student_id WHERE s.id = %d;", id);
        Student resultStudent = null;
        List<Course> studentCourses = new ArrayList<>();

        openConnection();

        try{
            ResultSet resultSet = executeQuery(query);
            resultSet.next();

            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            Integer firstCourseId = resultSet.getInt("course_id");
            String firstCourseTitle = resultSet.getString("title");

            if(firstCourseId != 0){
                studentCourses.add(new Course(firstCourseId, firstCourseTitle));

                while(resultSet.next()){
                    Integer courseId = resultSet.getInt("course_id");
                    String courseTitle = resultSet.getString("title");
                    studentCourses.add(new Course(courseId, courseTitle));
                }
            }

            resultStudent = new Student(id, name, surname);
            resultStudent.setCourseList(studentCourses);

        }
        catch (SQLException sqlException){
            //sqlException.printStackTrace();
        }

        closeConnection();

        return resultStudent;
    }

    @Override
    public void updateStudentById(int studentId, Student updatedStudent) {
        String updateStudentQuery = String.format("UPDATE `university`.`student` SET `name`='%s', `surname`='%s' WHERE `id`='%d';",
                updatedStudent.getName(), updatedStudent.getSurname(), updatedStudent.getId());
        executeUpdate(updateStudentQuery);
    }

    @Override
    public void deleteStudentById(int id) {
        String deleteQuery = String.format("DELETE FROM `university`.`student` WHERE `id`='%d';", id);
        executeUpdate(deleteQuery);
    }




}
