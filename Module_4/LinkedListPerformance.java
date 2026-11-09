/*
 * Performance Test Results:
 *
 * 50,000 integers:
 * Iterator: 1.4555 ms
 * get(index): 848.588125 ms
 *
 * 500,000 integers:
 * Iterator: 2.061208 ms
 * get(index): 96900.139 ms
 *
 * The Iterator method was much faster in both tests.
 * With 50,000 integers, get(index) was about 583 times slower.
 * With 500,000 integers, get(index) was about 47,011 times slower.
 *
 * This happens because LinkedList does not provide direct
 * access to elements by index. Each get(index) call must
 * traverse nodes to locate the requested element.
 *
 * An Iterator moves through the list sequentially, making
 * it more efficient for traversing a LinkedList.
 *
 * Increasing the list from 50,000 to 500,000 elements
 * caused get(index) to take much longer, while Iterator
 * traversal remained fast.
 *
 * Both methods returned the correct sums, confirming
 * that the program functions correctly.
 *
 * These results are from one test run and may vary.
 */

import java.util.LinkedList;
import java.util.Iterator;

/**
 * CSD-420 Module 4 Programming Assignment
 * Author: Luis Rodriguez
 * Date: November 8, 2026
 *
 * Compares LinkedList traversal using an Iterator
 * and the get(index) method.
 */
public class LinkedListPerformance {

    /**
     * Traverses the list using an Iterator.
     * Returns the sum to verify the results.
     */
    public static long testIterator(LinkedList<Integer> list) {
        long sum = 0;
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    /**
     * Traverses the list using get(index).
     * Returns the sum to verify the results.
     */
    public static long testGetIndex(LinkedList<Integer> list) {
        long sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    /**
     * Tests both traversal methods and compares results.
     */
    public static void runTest(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\nTesting " + size + " integers");

        long start = System.nanoTime();
        long iteratorSum = testIterator(list);
        long iteratorTime = System.nanoTime() - start;

        start = System.nanoTime();
        long getSum = testGetIndex(list);
        long getTime = System.nanoTime() - start;

        long expectedSum = (long) size * (size - 1) / 2;

        System.out.println("Iterator time: " +
            iteratorTime / 1_000_000.0 + " ms");

        System.out.println("get(index) time: " +
            getTime / 1_000_000.0 + " ms");

        System.out.println("Iterator sum: " + iteratorSum);
        System.out.println("get(index) sum: " + getSum);

        if (iteratorSum == expectedSum && getSum == expectedSum) {
            System.out.println("Test PASSED: Both methods return the correct sum.");
        } else {
            throw new AssertionError("Test FAILED: Incorrect sum.");
        }
    }

    public static void main(String[] args) {
        System.out.println("CSD-420 Module 4 - Luis Rodriguez");

        runTest(50000);
        runTest(500000);
    }
}
