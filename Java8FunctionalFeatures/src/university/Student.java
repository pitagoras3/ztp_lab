package university;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    private String name;
    private String surname;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String id;
    private Department department;

    public Student(String name, String surname, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.id = generateId();
    }

    private String generateId(){
        StringBuilder idGeneratorBuilder = new StringBuilder();
        idGeneratorBuilder.append(gender.getGenderId());
        idGeneratorBuilder.append(dateOfBirth.format(DateTimeFormatter.ofPattern("YYMMDD")));
        idGeneratorBuilder.append(Math.abs((name + surname).hashCode()));
        return idGeneratorBuilder.toString();
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", id='" + id + '\'' +
                '}';
    }
}
