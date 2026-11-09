import java.util.ArrayList;
import java.util.Random;

/**
 * CSD-420 Module 3 Programming Assignment
 * Author: Luis Rodriguez
 * Date: November 8, 2026
 *
 * Creates an ArrayList of 50 random integers and
 * removes duplicate values using a generic method.
 */
public class RemoveDuplicates {

    /**
     * Returns a new ArrayList containing unique values.
     *
     * @param list the original ArrayList
     * @param <E> the type of elements in the list
     * @return a new ArrayList without duplicates
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();

        for (E value : list) {
            if (!uniqueList.contains(value)) {
                uniqueList.add(value);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Generate 50 random numbers between 1 and 20.
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("CSD-420 Module 3 - Luis Rodriguez");
        System.out.println("--------------------------------");

        System.out.println("Original ArrayList:");
        System.out.println(originalList);

        System.out.println("\nArrayList without duplicates:");
        System.out.println(uniqueList);

        System.out.println("\nOriginal size: " + originalList.size());
        System.out.println("Unique size: " + uniqueList.size());
    }
}
