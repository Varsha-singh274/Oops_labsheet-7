/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 7: Creating User-Defined Exception (Custom)
 * Create a custom exception InvalidPasswordException. If the user enters a
 * password with less than 6 characters, throw this exception. Handle it in
 * main().
 *
 * Files   : InvalidPasswordException.java, Q07_CustomException.java
 * Compile : javac InvalidPasswordException.java Q07_CustomException.java
 * Run     : java Q07_CustomException
 */
import java.util.Scanner;

public class Q07_CustomException {

    static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 6) {
            throw new InvalidPasswordException(
                "Password too short! Length is " + password.length() + ", minimum required is 6.");
        }
        System.out.println("Password accepted.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
        } catch (InvalidPasswordException e) {
            System.out.println("InvalidPasswordException caught: " + e.getMessage());
        }
        sc.close();
    }
}
