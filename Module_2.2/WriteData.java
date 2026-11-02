/*
 * Luis Rodriguez
 * CSD420 - Module 2.2
 * Program: WriteData.java
 * Description: Generates five random integers and five
 * random doubles and appends them to a data file.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteData {

    public static void main(String[] args) {

        Random random = new Random();
        int[] integers = new int[5];
        double[] doubles = new double[5];

        for (int i = 0; i < 5; i++) {
            integers[i] = random.nextInt(100) + 1;
            doubles[i] = random.nextDouble() * 100;
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("Rodriguez datafile.dat", true))) {

            writer.println("Random Integers:");
            for (int number : integers) {
                writer.print(number + " ");
            }
            writer.println();

            writer.println("Random Doubles:");
            for (double number : doubles) {
                writer.printf("%.2f ", number);
            }
            writer.println();
            writer.println();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
