package com.marcinkiewicz.view_controller;

import com.marcinkiewicz.dao.*;

import java.util.Scanner;

public class HomeViewController {

    private static final String ID_EXIT = "exit";
    private static final String ID_DATA_SOURCE = "cds";
    private static final String ID_STUDENTS = "stud";

    private Scanner scanner;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private String dataSource;

    public HomeViewController(){
        scanner = new Scanner(System.in);

        changeDAOsToJSON();
    }

    public void start(){
        boolean isRunning = true;

        while(isRunning){
            showHomeMenu();
            String option = getOptionFromUser();
            if(option.equals(ID_EXIT)) {
                isRunning = false;
            }
            else if(option.equals(ID_DATA_SOURCE)) {
                changeDataSource();
            }
            else if(option.equals(ID_STUDENTS)) {
                openStudentsOptions();
            }
            else {
                wrongOption();
            }
        }
    }

    private void showHomeMenu(){
        System.out.println("\t<Current data source: " + dataSource + ">" );
        System.out.println("\tChoose option:");
        System.out.println("<cds>       Change data source.");
        System.out.println("<stud>      Go to students options.");
        System.out.println("<exit>      Exit application.");
    }

    private void changeDataSource(){
        System.out.println("Define new data source.");
        String newDataSource = scanner.next();
        if(newDataSource.equals("json")){
            changeDAOsToJSON();
        }
        else if(newDataSource.equals("db")){
            changeDAOsToDB();
        }
        else{
            System.out.println("Don't have that data source.");
        }
    }

    private void openStudentsOptions(){
        StudentViewController studentViewController = new StudentViewController(studentDAO, courseDAO);
        studentViewController.start();
    }

    private void wrongOption(){
        System.out.println("Choosen wrong option.");
    }

    private String getOptionFromUser(){
        String option = scanner.next();
        return option;
    }

    private void changeDAOsToJSON(){
        this.dataSource = "json";
        studentDAO = new StudentDAO_JSON();
        courseDAO = new CourseDAO_JSON();
    }

    private void changeDAOsToDB(){
        this.dataSource = "db";
        studentDAO = new StudentDAO_DB();
        courseDAO = new CourseDAO_DB();
    }

}
