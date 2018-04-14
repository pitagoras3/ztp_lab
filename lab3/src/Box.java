import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T> implements Cloneable {

    private T firstGenericObject;
    private T secondGenericObject;

    public Box() {
        this.firstGenericObject = new T();
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

    public void metodaFabrykujaca(){
        this.firstGenericObject = new T();
        this.secondGenericObject = new T();

    }

//    @Override
//    protected Object clone() {
//        Box<T> cloned = new Box<>();
//        try{
//            cloned.firstGenericObject = (T) this.firstGenericObject.getClass().getMethod("clone").invoke(this.firstGenericObject);
//            cloned.secondGenericObject = (T) this.secondGenericObject.getClass().getMethod("clone").invoke(this.secondGenericObject);
//        }
//        catch (NoSuchMethodException e) {
//            cloned.firstGenericObject = this.firstGenericObject;
//            cloned.secondGenericObject = this.secondGenericObject;
//        }
//        catch (InvocationTargetException e){
//            e.printStackTrace();
//        }
//        catch (IllegalAccessException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return cloned;
//    }

    protected Object clone() {
        Box<T> clonedBox = null;
        try {
            clonedBox = Box.class.newInstance();
            Class<?> currentClass = this.getClass();

            List<Field> fields = new ArrayList<>(Arrays.asList(currentClass.getDeclaredFields()));
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(clonedBox, field.get(this));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clonedBox;
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
