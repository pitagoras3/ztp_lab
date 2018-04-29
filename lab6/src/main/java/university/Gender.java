package university;

public enum Gender {
    FEMALE(1),
    MALE(2);

    private final int genderId;

    Gender(int genderId){
        this.genderId = genderId;
    }

    public int getGenderId(){
        return genderId;
    }

}
