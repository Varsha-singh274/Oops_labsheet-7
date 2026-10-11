/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 2: Array Index Out of Bounds
 * Create an array of 5 elements. Ask the user to enter an index and display
 * the value at that index. Handle invalid index using
 * ArrayIndexOutOfBoundsException.
 *
 * Compile : javac Q02_ArrayIndexOutOfBounds.java
 * Run     : java Q02_ArrayIndexOutOfBounds
 */
import java.util.Scanner;

public class Q02_ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};   // valid indexes: 0 to 4
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an index (array has 5 elements): ");
        int index = sc.nextInt();

        try {
            System.out.println("Value at index " + index + " = " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index! Please enter a value between 0 and "
                    + (arr.length - 1) + ".");
            System.out.println("Exception details: " + e.getMessage());
        }
        sc.close();
        System.out.println("Program ended normally.");
    }
}
