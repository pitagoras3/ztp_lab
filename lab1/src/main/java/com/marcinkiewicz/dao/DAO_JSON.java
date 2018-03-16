package com.marcinkiewicz.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class DAO_JSON {

    private static final String FILE_NAME = "students.json";
    private static final Integer DEFAULT_ID = 1;

    private BufferedWriter writer;

    List<Student> readAllStudents() {
        Gson gson = new Gson();
        List<Student> allStudents = gson.fromJson(readFromFile(), new TypeToken<List<Student>>(){}.getType());
        return allStudents;
    }

    String readFromFile(){
        String jsonFromFile = "";

        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            StringBuilder builder = new StringBuilder();

            while(scanner.hasNext()){
                builder.append(scanner.nextLine());
            }

            jsonFromFile = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonFromFile;
    }

    boolean isFileEmpty() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (br.readLine() == null) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    void writeToFile(String jsonToWrite){
        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(jsonToWrite);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int getNextStudentId(){
        if(isFileEmpty()){
            return DEFAULT_ID;
        }
        else{
            int maxId = 0;
            List<Student> allStudents = readAllStudents();
            for(Student student: allStudents){
                if(student.getId() > maxId){
                    maxId = student.getId();
                }
            }
            return ++maxId;
        }
    }

    void saveNewListOfStudents(List<Student> allStudents){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonToSave = gson.toJson(allStudents);
        writeToFile(jsonToSave);
    }

    int getNextCourseId(int studentId){
        if(isFileEmpty()){
            return DEFAULT_ID;
        }
        else{
            int maxId = 0;
            List<Course> allCourses = getAllCourses();

            for (Course course : allCourses) {
                if (course.getId() > maxId) {
                    maxId = course.getId();
                }
            }
            return ++maxId;
        }
    }

    private List<Course> getAllCourses(){
        List<Student> allStudents = readAllStudents();
        List<Course> allCourses = new ArrayList<>();
        for(Student student: allStudents){
            allCourses.addAll(student.getCourseList());
        }
        return allCourses;
    }

}
