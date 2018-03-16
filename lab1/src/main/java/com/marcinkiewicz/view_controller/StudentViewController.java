package com.marcinkiewicz.view_controller;

import com.marcinkiewicz.dao.CourseDAO;
import com.marcinkiewicz.dao.StudentDAO;
import com.marcinkiewicz.model.Course;
import com.marcinkiewicz.model.Student;
import com.marcinkiewicz.service.CourseService;
import com.marcinkiewicz.service.CourseServiceImpl;
import com.marcinkiewicz.service.StudentService;
import com.marcinkiewicz.service.StudentServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentViewController {

    private static final String ID_EXIT = "exit";
    private static final String ID_CREATE_STUDENT = "cs";
    private static final String ID_CREATE_COURSE = "cc";
    private static final String ID_READ = "r";
    private static final String ID_UPDATE = "u";
    private static final String ID_DELETE_STUDENT = "ds";
    private static final String ID_DELETE_COURSE = "dc";


    private Scanner scanner;
    private StudentService studentService;
    private CourseService courseService;

    public StudentViewController(StudentDAO studentDAO, CourseDAO courseDAO){
        studentService = new StudentServiceImpl(studentDAO);
        courseService = new CourseServiceImpl(courseDAO);
        scanner = new Scanner(System.in);
    }

    public void start(){

        boolean isRunning = true;
        while(isRunning){
            showStudentMenu();
            String options[] = getOptionFromUser();
            String option = options[0];
            int optionId = -1;

            if(options.length == 2){
                try{
                    optionId = Integer.parseInt(options[1]);
                }
                catch(NumberFormatException e){
                    System.out.println("Second argument is not a number.");
                    optionId = -1;
                }
            }

            if(option.equals(ID_EXIT)){
                isRunning = false;
            }
            else if(option.equals(ID_CREATE_STUDENT)){
                createNewStudent();
            }
            else if(option.equals(ID_CREATE_COURSE)){
                if(optionId == -1){
                    System.out.println("Didn't received ID.");
                }
                else{
                    createNewCourseToStudent(optionId);
                }
            }
            else if(option.equals(ID_READ)){
                if(optionId == -1){
                    readAllStudents();
                }
                else{
                    readStudentById(optionId);
                }
            }
            else if(option.equals(ID_UPDATE)){
                if(optionId == -1){
                    System.out.println("Didn't received ID.");
                }
                else{
                    updateStudentById(optionId);
                }
            }
            else if(option.equals(ID_DELETE_STUDENT)){
                if(optionId == -1){
                    System.out.println("Didn't received ID.");
                }
                else{
                    deleteStudentById(optionId);
                }
            }
            else if(option.equals(ID_DELETE_COURSE)){
                if(optionId == -1){
                    System.out.println("Didn't received ID.");
                }
                else{
                    deleteCourseFromStudent(optionId);
                }
            }
            else {
                System.out.println("Wrong option.");
            }
        }
    }

    private void showStudentMenu(){
        System.out.println("\n\tStudent options:");
        System.out.println("\tChoose option:");
        System.out.println("<cs>        Create new student.");
        System.out.println("<cc [i]>    Add new course to student with id <i>.");
        System.out.println("<r>         Read all students.");
        System.out.println("<r [i]>     Read student with id <i>.");
        System.out.println("<u [i]>     Update student with id <i>.");
        System.out.println("<ds [i]>    Delete student with id <i>.");
        System.out.println("<dc [i]>    Delete course of student with id <i>.");
        System.out.println("<exit>      Go to home.");
    }

    private String[] getOptionFromUser(){
        String option = scanner.nextLine();
        if(option.equals("")){
            option = scanner.nextLine();
        }
        return option.split(" ");
    }

    private void createNewStudent(){
        System.out.println("Name: ");
        String name = scanner.next();

        System.out.println("Surname: ");
        String surname = scanner.next();

        Student newStudent = new Student(name, surname);
        studentService.createNewStudent(newStudent);
    }

    private void createNewCourseToStudent(int id){
        boolean isStudentInDatasource = readStudentById(id);

        if(isStudentInDatasource){
            System.out.println("Title of new course: ");
            String title = scanner.next();
            Course newCourse = new Course(title);
            courseService.createNewCourseToStudent(id, newCourse);
        }
    }

    private void readAllStudents(){
        List<Student> allStudents = studentService.readAllStudents();

        if(allStudents != null){
            StringBuilder builder = new StringBuilder();

            String line = "+-----------------------------------------------+\n";
            String header = String.format("|%-5s|%-20s|%-20s|%n", "ID", "Name", "Suraname");
            builder.append(line);
            builder.append(header);

            for(Student student : allStudents){
                String row = String.format("|%-5d|%-20s|%-20s|%n", student.getId(), student.getName(), student.getSurname());
                builder.append(row);
            }

            builder.append(line);

            System.out.print(builder.toString());
        }
        else{
            System.out.println("No students in data source.");
        }
    }

    private boolean readStudentById(int id){
        Student student = studentService.readStudentById(id);
        if(student != null){
            StringBuilder studentBuilder = new StringBuilder();
            StringBuilder coursesBuilder = new StringBuilder();

            if(student.getCourseList().size() == 0){
                coursesBuilder.append("|Have no courses.");
            }
            else{
                for(Course course : student.getCourseList()){
                    String courseRow = String.format("|[ID: %-2d][Title: %-5s]", course.getId(), course.getTitle());
                    coursesBuilder.append(courseRow);
                }
            }

            String line = "+------------------------------------------------------+\n";
            String header = String.format("|%-5s|%-20s|%-20s|%-50s%n", "ID", "Name", "Suraname", "Courses");
            String row = String.format("|%-5d|%-20s|%-20s%-50s%n", student.getId(), student.getName(), student.getSurname(), coursesBuilder.toString());

            studentBuilder.append(line);
            studentBuilder.append(header);
            studentBuilder.append(row);
            studentBuilder.append(line);

            System.out.println(studentBuilder.toString());
            return true;
        }
        else{
            System.out.println("No student with that id.");
            return false;
        }
    }

    private void updateStudentById(int id){
        boolean isStudentInDatasource = readStudentById(id);

        if(isStudentInDatasource){
            System.out.println("Change name: ");
            String name = scanner.next();

            System.out.println("Change surname: ");
            String surname = scanner.next();

            Student updatedStudent = new Student(id, name, surname);

            studentService.updateStudentById(id, updatedStudent);
        }
    }

    private void deleteStudentById(int id){
        boolean isStudentInDatasource = readStudentById(id);

        if(isStudentInDatasource){
            Student studentToDelete = studentService.readStudentById(id);
            boolean correctDecisionFlag = false;
            boolean decision = false;

            while(!correctDecisionFlag){
                System.out.println("Are you sure to delete this student?");
                System.out.println("[y/n]");
                String dec = scanner.next();
                if(dec.equals("y")){
                    decision = true;
                    correctDecisionFlag = true;
                }
                else if(dec.equals("n")){
                    decision = false;
                    correctDecisionFlag = true;
                }
                else{
                    System.out.println("You wrote wrong letter, try again.");
                }
            }

            if(decision){
                studentService.deleteStudentById(id);
            }
        }
    }

    private void deleteCourseFromStudent(int studentId){
        boolean isStudentInDatasource = readStudentById(studentId);

        if(isStudentInDatasource){
            System.out.println("Course to delete ID: ");
            try{
                Integer courseId = scanner.nextInt();
                courseService.deleteCourseFromStudent(courseId);
            }
            catch(InputMismatchException e){
                System.out.println("Wrong course to delete, try again.");
            }

        }
    }
}
