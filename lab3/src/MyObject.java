public class MyObject implements Cloneable {

    private String value;

    public MyObject(){
        this.value = "";
    }

    public MyObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    @Override
//    public String toString() {
//        return "MyObject value: " + value;
//    }

    @Override
    protected MyObject clone() throws CloneNotSupportedException {
        MyObject clonedMyObject = new MyObject(this.value);
        return clonedMyObject;
    }
}
