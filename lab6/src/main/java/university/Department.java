package university;

import java.time.LocalDate;

public class Department {

    private String name;
    private LocalDate dateOfCreation;

    public Department(String name, LocalDate dateOfCreation) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%3s, created in %d", name, dateOfCreation.getYear());
    }
}
