import java.lang.reflect.InvocationTargetException;

public class Box<T> implements Cloneable {

    private T firstGenericObject;
    private T secondGenericObject;

    public Box() {
        this.firstGenericObject = null;
        this.secondGenericObject = null;
    }

    //Constructor as fabric method
    public Box(String className){
        try{
            Class clazz = Class.forName(className);
            this.firstGenericObject = (T) clazz.newInstance();
            this.secondGenericObject = (T) clazz.newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    public Box(T firstGenericObject, T secondGenericObject) {
        this.firstGenericObject = firstGenericObject;
        this.secondGenericObject = secondGenericObject;
    }

    public T getFirstGenericObject() {
        return firstGenericObject;
    }

    public void setFirstGenericObject(T firstGenericObject) {
        this.firstGenericObject = firstGenericObject;
    }

    public T getSecondGenericObject() {
        return secondGenericObject;
    }

    public void setSecondGenericObject(T secondGenericObject) {
        this.secondGenericObject = secondGenericObject;
    }

    @Override
    protected Object clone() {
        Box<T> cloned = new Box<>();
        try{
            cloned.firstGenericObject = (T) this.firstGenericObject.getClass().getMethod("clone").invoke(this.firstGenericObject);
            cloned.secondGenericObject = (T) this.secondGenericObject.getClass().getMethod("clone").invoke(this.secondGenericObject);
        }
        catch (NoSuchMethodException e) {
            cloned.firstGenericObject = this.firstGenericObject;
            cloned.secondGenericObject = this.secondGenericObject;
        }
        catch (InvocationTargetException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }

        return cloned;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("First generic object: [");
        stringBuilder.append(firstGenericObject.toString());
        stringBuilder.append("] Second generic object: [");
        stringBuilder.append(secondGenericObject.toString());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
