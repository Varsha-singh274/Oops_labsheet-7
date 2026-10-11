/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 8: Using throws keyword
 * Write a method to read a number from the user and convert to integer.
 * Declare the method using throws NumberFormatException and handle the
 * exception in the calling method.
 *
 * Compile : javac Q08_ThrowsKeyword.java
 * Run     : java Q08_ThrowsKeyword
 */
import java.util.Scanner;

public class Q08_ThrowsKeyword {

    // The method does NOT handle the exception; it declares it with 'throws'
    static int readNumber(Scanner sc) throws NumberFormatException {
        System.out.print("Enter a number: ");
        String input = sc.nextLine();
        return Integer.parseInt(input.trim());   // may throw NumberFormatException
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = readNumber(sc);                  // calling method handles it
            System.out.println("You entered: " + n + " (square = " + (n * n) + ")");
        } catch (NumberFormatException e) {
            System.out.println("Caught in main(): invalid number. " + e.getMessage());
        }
        sc.close();
    }
}
