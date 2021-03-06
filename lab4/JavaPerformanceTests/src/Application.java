import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Application {

    //Random numbers generating object
    private static final Random random = new Random();

    //Constants
    public static final int AMOUNT_OF_TESTS     = 10;
    public static final int ONE_THOUSAND        = 1000;
    public static final int TEN_THOUSAND        = 10000;
    public static final int HUNDRED_THOUSAND    = 100000;

    //Test objects
    private static UnoptimizedArraysTests unoptimizedTests_1000;
    private static OptimizedArraysTests optimizedTests_1000;
    private static UnoptimizedArraysTests unoptimizedTests_10000;
    private static OptimizedArraysTests optimizedTests_10000;
    private static UnoptimizedArraysTests unoptimizedTests_100000;
    private static OptimizedArraysTests optimizedTests_100000;


    //Test times
    private static ArrayList<Long> unoptimizedTests_1000_times;
    private static ArrayList<Long> optimizedTests_1000_times;

    private static ArrayList<Long> unoptimizedTests_10000_times;
    private static ArrayList<Long> optimizedTests_10000_times;

    private static ArrayList<Long> unoptimizedTests_100000_times;
    private static ArrayList<Long> optimizedTests_100000_times;

    public static void main(String[] args){
        unoptimizedTests_1000_times = new ArrayList<>();
        optimizedTests_1000_times = new ArrayList<>();

        unoptimizedTests_10000_times = new ArrayList<>();
        optimizedTests_10000_times = new ArrayList<>();

        unoptimizedTests_100000_times = new ArrayList<>();
        optimizedTests_100000_times = new ArrayList<>();

        unoptimizedTests_1000 = new UnoptimizedArraysTests(ONE_THOUSAND);
        optimizedTests_1000 = new OptimizedArraysTests(ONE_THOUSAND);

        unoptimizedTests_10000 = new UnoptimizedArraysTests(TEN_THOUSAND);
        optimizedTests_10000 = new OptimizedArraysTests(TEN_THOUSAND);

        unoptimizedTests_100000 = new UnoptimizedArraysTests(HUNDRED_THOUSAND);
        optimizedTests_100000 = new OptimizedArraysTests(HUNDRED_THOUSAND);

        for(int i = 0; i < AMOUNT_OF_TESTS; i++){
            setAllArraysRandom();

            unoptimizedTests_1000_times.add(performanceTestMethod(unoptimizedTests_1000));
            optimizedTests_1000_times.add(performanceTestMethod(optimizedTests_1000));

            unoptimizedTests_10000_times.add(performanceTestMethod(unoptimizedTests_10000));
            optimizedTests_10000_times.add(performanceTestMethod(optimizedTests_10000));

            unoptimizedTests_100000_times.add(performanceTestMethod(unoptimizedTests_100000));
            optimizedTests_100000_times.add(performanceTestMethod(optimizedTests_100000));
            
        }

        sortTestTimes();
        showResults();
    }

    private static long performanceTestMethod(ArraysTests arraysTests){
        long startTime = System.nanoTime();
        arraysTests.sort();
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    private static void sortTestTimes(){
        Collections.sort(unoptimizedTests_1000_times);
        Collections.sort(optimizedTests_1000_times);

        Collections.sort(unoptimizedTests_10000_times);
        Collections.sort(optimizedTests_10000_times);

        Collections.sort(unoptimizedTests_100000_times);
        Collections.sort(optimizedTests_100000_times);
    }

    private static long countMedianFromList(ArrayList<Long> list){
        if(list.size() % 2 != 0){
            int medianIndex = (list.size() - 1) / 2;
            return list.get(medianIndex);
        }
        else {
            int leftMedianIndex = (list.size() - 1) / 2 ;
            int rightMedianIndex = list.size() / 2;

            return (list.get(leftMedianIndex) + list.get(rightMedianIndex)) / 2;
        }
    }

    private static void showResults(){
        System.out.println("===========  1000 Times  ===========");
        System.out.printf("%-25s %-10d %n", "Unoptimized 1000 time:", countMedianFromList(unoptimizedTests_1000_times));
        System.out.printf("%-25s %-10d %n%n", "Optimized 1000 time:", countMedianFromList(optimizedTests_1000_times));

        System.out.println("===========  10000 Times ===========");
        System.out.printf("%-25s %-10d %n", "Unoptimized 10000 time:", countMedianFromList(unoptimizedTests_10000_times));
        System.out.printf("%-25s %-10d %n%n", "Optimized 10000 time:", countMedianFromList(optimizedTests_10000_times));

        System.out.println("=========== 100000 Times ===========");
        System.out.printf("%-25s %-10d %n", "Unoptimized 1000000 time:", countMedianFromList(unoptimizedTests_100000_times));
        System.out.printf("%-25s %-10d %n", "Optimized 100000 time:", countMedianFromList(optimizedTests_100000_times));
    }

    private static void setAllArraysRandom(){

        ArrayList<Integer> oneThousandRandomIntegers = createRandomIntegerList(ONE_THOUSAND);
        ArrayList<Integer> tenThousandRandomIntegers = createRandomIntegerList(TEN_THOUSAND);
        ArrayList<Integer> hundredThousandRandomIntegers = createRandomIntegerList(HUNDRED_THOUSAND);

        unoptimizedTests_1000.setRandomArray(oneThousandRandomIntegers);
        optimizedTests_1000.setRandomArray(oneThousandRandomIntegers);

        unoptimizedTests_10000.setRandomArray(tenThousandRandomIntegers);
        optimizedTests_10000.setRandomArray(tenThousandRandomIntegers);

        unoptimizedTests_100000.setRandomArray(hundredThousandRandomIntegers);
        optimizedTests_100000.setRandomArray(hundredThousandRandomIntegers);
    }

    private static ArrayList<Integer> createRandomIntegerList(int listSize){
        ArrayList<Integer> randomIntegerList = new ArrayList<>();

        for(int i = 0; i < listSize; i++){
            randomIntegerList.add(random.nextInt());
        }

        return randomIntegerList;
    }
}
