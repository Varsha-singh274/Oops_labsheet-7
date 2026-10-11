/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 4: Nested try blocks
 * Write a program with a nested try structure:
 *   - Inner try: Access an array element.
 *   - Outer try: Divide two numbers.
 * Use separate catch blocks accordingly.
 *
 * Compile : javac Q04_NestedTry.java
 * Run     : java Q04_NestedTry
 */
import java.util.Scanner;

public class Q04_NestedTry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5, 10, 15, 20, 25};

        try {   // ---------- OUTER TRY : division ----------
            System.out.print("Enter numerator   : ");
            int a = sc.nextInt();
            System.out.print("Enter denominator : ");
            int b = sc.nextInt();

            try {   // ---------- INNER TRY : array access ----------
                System.out.print("Enter array index (0-4): ");
                int idx = sc.nextInt();
                System.out.println("Array element = " + arr[idx]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: Invalid array index! " + e.getMessage());
            }

            // Executed after the inner try-catch (an inner exception is already handled)
            System.out.println("Division result = " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Cannot divide by zero! " + e.getMessage());
        }
        sc.close();
        System.out.println("Program finished.");
    }
}
