public class Box<T> {

    private T genericObject;

    public Box(){}

    public Box(T genericObject){
        this.genericObject = genericObject;
    }

    public T getGenericObject() {
        return genericObject;
    }

    public void setGenericObject(T genericObject) {
        this.genericObject = genericObject;
    }
}
