/*
 * Luis Rodriguez
 * CSD420 - Module 2.2
 * Program: ReadData.java
 * Description: Reads the saved data file and displays
 * the stored integers and double values.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

    public static void main(String[] args) {

        File file = new File("Rodriguez datafile.dat");

        try (Scanner reader = new Scanner(file)) {

            System.out.println("Data from file:");
            System.out.println();

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Data file was not found.");
        }
    }
}
