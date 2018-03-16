package com.marcinkiewicz.model;

import java.util.List;

public class Course {

    private Integer id;
    private String title;

    public Course(){}

    public Course(String title) {
        this.title = title;
    }

    public Course(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
