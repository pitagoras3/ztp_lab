import java.util.ArrayList;
import java.util.stream.Collectors;

public class UnoptimizedArraysTests implements ArraysTests {

    private int arraySize;
    private ArrayList<Integer> intArray;

    public UnoptimizedArraysTests(int arraySize){
        this.arraySize = arraySize;
        this.intArray = new ArrayList<>(arraySize);
    }

    public void sort(){
//        intArray.sort(Comparator.naturalOrder());
        intArray = intArray.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public void setRandomArray(ArrayList<Integer> randomIntegers){
        intArray.clear();
        intArray.addAll(randomIntegers);
    }
}
