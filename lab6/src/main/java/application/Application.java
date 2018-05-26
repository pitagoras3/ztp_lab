package application;


import org.apache.commons.lang3.StringUtils;
import university.Course;
import university.Department;
import university.Gender;
import university.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Application {

    private static ArrayList<Student> students = new ArrayList<>();

    private static Department itDepartment = new Department("W8", LocalDate.of(1982, 2, 1));
    private static Department mechanicalDepartment = new Department("W11", LocalDate.of(1970, 6, 1));
    private static Department electronicsDepartment = new Department("W4", LocalDate.of(1991, 4, 3));

    private static Course androidCourse =   new Course("Android", 2);
    private static Course iosCourse     =   new Course("iOS", 2);
    private static Course javaCourse    =   new Course("Java", 3);
    private static Course pythonCourse  =   new Course("Python", 3);
    private static Course mathCourse    =   new Course("Math", 6);
    private static Course algebraCourse =   new Course("Algebra", 4);
    private static Course enginesCourse =   new Course("Engines", 3);
    private static Course englishCourse =   new Course("English", 2);
    private static Course arduinoCourse =   new Course("Arduino", 3);

    public static void main(String[] args) {

        fillStudentsList();

        printWrapper("ALL STUDENTS");
        printStudentsList();

        printWrapper("IT STUDENTS");
        printItStudents();

        printWrapper("STUDENTS DEPARTMENTS");
        printNameOfDepartmentForAllStudents();

        printWrapper("STUDENT WITH MOST COURSES");
        printStudentsWithMostCourses();

        printWrapper("STUDENT WITH LEAST ECTS");
        printStudentsWithLeastEcts();

        printWrapper("AVERAGE AGE");
        printAverageStudentsAgeGroupedByGender();

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

        studentAnna.setDepartment(itDepartment);
        studentSimon.setDepartment(itDepartment);
        studentMark.setDepartment(mechanicalDepartment);
        studentBob.setDepartment(electronicsDepartment);
        studentFrank.setDepartment(itDepartment);
        studentSuzzie.setDepartment(electronicsDepartment);
        studentTom.setDepartment(mechanicalDepartment);
        studentGeorge.setDepartment(electronicsDepartment);

        studentAnna.addCourses(Arrays.asList(androidCourse, iosCourse, mathCourse));
        studentSimon.addCourses(Arrays.asList(javaCourse, pythonCourse, mathCourse, algebraCourse, arduinoCourse));
        studentMark.addCourses(Arrays.asList(enginesCourse, mathCourse, algebraCourse));
        studentBob.addCourses(Arrays.asList(englishCourse));
        studentFrank.addCourses(Arrays.asList(androidCourse, iosCourse));
        studentSuzzie.addCourses(Arrays.asList(arduinoCourse));
        studentTom.addCourses(Arrays.asList(enginesCourse));
        studentGeorge.addCourses(Arrays.asList(arduinoCourse, englishCourse, mathCourse));


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
        students.forEach(student -> System.out.println(student));
    }

    private static void printWrapper(String title){
        System.out.println("\n============================================================");
        String centralizedTitle = StringUtils.center(title, 40);
        System.out.printf("==========%s==========%n", centralizedTitle);
        System.out.println("============================================================\n");
    }

    // Tasks
    // Filter
    private static void printItStudents(){
        students.stream()
                .filter(student -> student.getDepartment().equals(itDepartment))
                .forEach(System.out::println);
    }

    // Map
    private static void printNameOfDepartmentForAllStudents(){
        students.stream()
                .map(Student::getDepartment)
                .forEach(System.out::println);
    }

    // Min/max
    private static void printStudentsWithMostCourses(){
        Student studentWithMostCourses = students.stream()
                .max(Comparator.comparingInt(o -> o.getCourses().size()))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(studentWithMostCourses);
    }

    private static void printStudentsWithLeastEcts(){
        Student studentWithLeastEcts = students.stream()
                .min(Comparator.comparingInt(Student::countEcts))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(studentWithLeastEcts);
    }

    // Grouping by
    private static void printAverageStudentsAgeGroupedByGender(){
        Map<Gender, Double> averageStudentsAgeGroupedByGender = students.stream()
                .collect(groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        averageStudentsAgeGroupedByGender.forEach((gender, average) -> {
            System.out.printf("%-6s : %f%n", gender, average);
        });

    }

}
