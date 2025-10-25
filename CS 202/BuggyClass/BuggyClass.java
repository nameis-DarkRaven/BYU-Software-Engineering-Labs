package Debugging;

import java.util.ArrayList;
import java.util.List;

public class BuggyClass {

    public static void main(String[] args) {
        long sum = longLoop(100000, 2);
        System.out.println(sum);
        printListOfSums();
    }

    /**
     * Takes in a number to increment towards and an increment value. Returns a positive long after
     * summing from 1 to max incrementing by increment
     * @param max The maximum number that could be added to sum
     * @param increment The value to increment by
     * @return A positive long summing values from 1 to max, incrementing by increment
     */
    private static long longLoop(double max, int increment) {
        long sum = 1;
        for (int i = 1; i < max; i += increment) {
            sum += i;
        }
        return sum;
    }

    /**
     * Prints a list of increasing numbers created by longLoop. Max increases by powers of 10 from 10^5 to 10^9.
     * Increment goes from 5 to 9, inclusive.
     */
    private static void printListOfSums() {
        List<Long> list = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            Long sum = longLoop(Math.pow(10, i), i);
            list.add(sum);
        }
        for (int i = 0; i < list.size(); i++) {
            long sum = list.get(i);
            System.out.println(sum);
        }
    }
}