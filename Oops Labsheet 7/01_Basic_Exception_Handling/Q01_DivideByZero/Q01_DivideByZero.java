/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 1: Divide by Zero Exception (ArithmeticException)
 * Write a program to accept two integers from the user and perform division.
 * Handle the case where the denominator is zero using try-catch-finally.
 *
 * Compile : javac Q01_DivideByZero.java
 * Run     : java Q01_DivideByZero
 */
import java.util.Scanner;

public class Q01_DivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator   : ");
        int a = sc.nextInt();
        System.out.print("Enter denominator : ");
        int b = sc.nextInt();

        try {
            // Integer division by zero throws ArithmeticException
            int result = a / b;
            System.out.println("Result of " + a + " / " + b + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero! (" + e.getMessage() + ")");
        } finally {
            // finally always runs, whether or not an exception occurred
            System.out.println("Finally block executed: division attempt finished.");
            sc.close();
        }
    }
}
