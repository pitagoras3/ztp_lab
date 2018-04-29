package university;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String surname;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String id;
    private Department department;
    private List<Course> courses;

    public Student(String name, String surname, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.id = generateId();
        this.courses = new ArrayList<>();
    }

    private String generateId(){
        StringBuilder idGeneratorBuilder = new StringBuilder();
        idGeneratorBuilder.append(gender.getGenderId());
        idGeneratorBuilder.append(dateOfBirth.format(DateTimeFormatter.ofPattern("YYMMDD")));
        idGeneratorBuilder.append(Math.abs((name + surname).hashCode()));
        return idGeneratorBuilder.toString().substring(0, 12);
    }

    public int countEcts(){
        return courses.stream().mapToInt(Course::getEcts).sum();
    }

    public void addCourses(List<Course> coursesToAdd){
        courses.addAll(coursesToAdd);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge(){
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10s %-20s %10s", id, name, surname, dateOfBirth);
    }

}
