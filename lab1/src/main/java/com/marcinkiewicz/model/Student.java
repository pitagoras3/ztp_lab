package com.marcinkiewicz.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private Integer id;
    private String name;
    private String surname;
    private List<Course> courseList;

    public Student(){}

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        courseList = new ArrayList<>();
    }

    public Student(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        courseList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String toStringWithCourses() {
        StringBuilder courses = new StringBuilder();
        if(courseList.size() == 0){
            courses.append("No course assigned to student!");
        }
        else{
            courses.append("[");
            for(Course course : courseList){
                courses.append("|");
                courses.append(course.getId());
                courses.append(". ");
                courses.append(course.toString());
                courses.append("|");
            }
            courses.append("]");
        }

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", courses=" + courses.toString() +
                '}';
    }
}
