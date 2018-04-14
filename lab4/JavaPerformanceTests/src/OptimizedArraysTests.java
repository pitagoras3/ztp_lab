import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class OptimizedArraysTests implements ArraysTests {

    private int arraySize;
    private ArrayList<Integer> intArray;

    private Random random;

    public OptimizedArraysTests(int arraySize){
        this.arraySize = arraySize;
        this.intArray = new ArrayList<>(arraySize);
        this.random = new Random();

        fillArrayRandomly();
    }

    public void fillArrayRandomly(){
        for(int i = 0; i < arraySize; i++){
            intArray.add(random.nextInt());
        }
    }

    public void sort(){
        intArray.sort(Comparator.naturalOrder());
    }

    public void reset(){
        intArray.clear();
        fillArrayRandomly();
    }
}
