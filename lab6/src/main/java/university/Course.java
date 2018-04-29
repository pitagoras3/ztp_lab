package university;

public class Course {

    private String name;
    private int ects;

    public Course(String name, int ects) {
        this.name = name;
        this.ects = ects;
    }

    public int getEcts() {
        return ects;
    }
}
