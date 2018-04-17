import java.util.ArrayList;
import java.util.Arrays;

public class OptimizedArraysTests implements ArraysTests {

    private int arraySize;
    private int[] intArray;

    public OptimizedArraysTests(int arraySize){
        this.arraySize = arraySize;
        this.intArray = new int[arraySize];
    }

    public void sort(){
        Arrays.sort(intArray);
    }

    public void setRandomArray(ArrayList<Integer> randomIntegers){
        for(int i = 0; i < arraySize; i++){
            intArray[i] = randomIntegers.get(i);
        }
    }
}
