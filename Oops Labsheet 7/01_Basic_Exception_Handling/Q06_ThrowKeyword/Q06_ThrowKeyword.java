/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 6: Using throw keyword
 * Write a method checkAge(int age) that throws an exception if age < 18.
 * Call the method and handle the exception in main().
 *
 * Compile : javac Q06_ThrowKeyword.java
 * Run     : java Q06_ThrowKeyword
 */
import java.util.Scanner;

public class Q06_ThrowKeyword {

    // 'throw' explicitly creates and throws an exception object
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age " + age + " is below 18. Not eligible!");
        }
        System.out.println("Age " + age + " is valid. You are eligible.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main(): " + e.getMessage());
        }
        sc.close();
        System.out.println("Program ended.");
    }
}
