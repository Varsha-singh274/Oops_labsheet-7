/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 3: Multiple catch blocks
 * Write a program to accept two numbers (as strings), convert them to
 * integers, and divide. Handle:
 *   - NumberFormatException
 *   - ArithmeticException
 * using separate catch blocks.
 *
 * Compile : javac Q03_MultipleCatchBlocks.java
 * Run     : java Q03_MultipleCatchBlocks
 */
import java.util.Scanner;

public class Q03_MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number  : ");
        String s1 = sc.nextLine();
        System.out.print("Enter second number : ");
        String s2 = sc.nextLine();

        try {
            int a = Integer.parseInt(s1.trim());   // may throw NumberFormatException
            int b = Integer.parseInt(s2.trim());
            int result = a / b;                    // may throw ArithmeticException
            System.out.println("Result = " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers only. (" + e.getMessage() + ")");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed. (" + e.getMessage() + ")");
        }
        sc.close();
        System.out.println("Program finished.");
    }
}
