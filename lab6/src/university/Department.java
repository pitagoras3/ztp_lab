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
}
