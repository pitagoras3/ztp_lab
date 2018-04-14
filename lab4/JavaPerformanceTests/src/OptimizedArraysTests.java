import java.util.Arrays;
import java.util.Random;

public class OptimizedArraysTests implements ArraysTests {

    private int arraySize;
    private int[] intArray;

    private Random random;

    public OptimizedArraysTests(int arraySize){
        this.arraySize = arraySize;
        this.intArray = new int[arraySize];
        this.random = new Random();

        fillArrayRandomly();
    }

    public void fillArrayRandomly(){
        for(int i = 0; i < arraySize; i++){
            intArray[i] = random.nextInt();
        }
    }

    public void sort(){
        Arrays.sort(intArray);
    }

    public void reset(){
        fillArrayRandomly();
    }
}
