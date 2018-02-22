package com.marcinkiewicz.controller;

import java.util.Scanner;

public class HomeController {

    private static final int ID_EXIT = 0;
    private static final int ID_DATA_SOURCE = 1;
    private static final int ID_STUDENTS = 2;
    private static final int ID_COURSES = 3;

    private Scanner scanner;

    //Dummy
    private String dataSource;

    public HomeController(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        boolean isRunning = true;

        while(isRunning){
            showHomeMenu();
            int option = getOptionFromUser();
            switch(option){
                case ID_EXIT:
                    isRunning = false;
                    break;
                case ID_DATA_SOURCE:
                    changeDataSource();
                    break;
                case ID_STUDENTS:
                    openStudentsOptions();
                    break;
                case ID_COURSES:
                    openCoursesOptions();
                    break;
                default:
                    break;
            }
        }
    }

    private void showHomeMenu(){
        System.out.println("\t<Current data source: " + dataSource + ">" );
        System.out.println("\tChoose option:");
        System.out.println("[1]     Change data source.");
        System.out.println("[2]     Go to students options.");
        System.out.println("[3]     Go to courses options.");
    }

    private void changeDataSource(){
        System.out.println("Define new data source.");
        String newDataSource = scanner.next();
        this.dataSource = newDataSource;
    }

    private void openStudentsOptions(){
        StudentController studentController = new StudentController();
        studentController.start();
    }

    private void openCoursesOptions(){

    }

    private int getOptionFromUser(){
        int option = scanner.nextInt();
        return option;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource){
        this.dataSource = dataSource;
    }
}
