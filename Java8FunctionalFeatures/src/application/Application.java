package application;

import university.Gender;
import university.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        fillListsWithData();
        printStudentsList();

    }

    private static void fillListsWithData(){

        fillStudentsList();


    }

    private static void fillStudentsList(){

        Student studentAnna     = new Student("Anna", "Horak", Gender.FEMALE, LocalDate.of(1996, 5, 14));
        Student studentSimon    = new Student("Simon", "Marcinkiewicz", Gender.MALE, LocalDate.of(1996, 9, 13));
        Student studentMark     = new Student("Mark", "Owen", Gender.MALE, LocalDate.of(1998, 1, 12));
        Student studentBob      = new Student("Bob", "Smith", Gender.MALE, LocalDate.of(1997, 3, 2));
        Student studentFrank    = new Student("Frank", "Williams", Gender.MALE, LocalDate.of(1995, 10, 8));
        Student studentSuzzie   = new Student("Suzzie", "Conor", Gender.FEMALE, LocalDate.of(1994, 12, 5));
        Student studentTom      = new Student("Tom", "Jobs", Gender.MALE, LocalDate.of(1997, 2, 18));
        Student studentGeorge   = new Student("George", "Schulz", Gender.MALE, LocalDate.of(1998, 6, 22));

        students.add(studentAnna);
        students.add(studentSimon);
        students.add(studentMark);
        students.add(studentBob);
        students.add(studentFrank);
        students.add(studentSuzzie);
        students.add(studentTom);
        students.add(studentGeorge);

    }

    private static void printStudentsList(){

        students.stream().forEach(student -> System.out.println(student));

    }



}
