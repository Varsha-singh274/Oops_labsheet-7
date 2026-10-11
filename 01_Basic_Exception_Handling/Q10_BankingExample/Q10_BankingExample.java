/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 10: Banking example - User-defined + built-in exceptions
 * Create a BankAccount class with balance. Method withdraw(amount):
 *   - If amount > balance, throw InsufficientFundsException (user-defined).
 *   - If amount is negative, throw IllegalArgumentException (built-in).
 * Handle both in main().
 *
 * Files   : InsufficientFundsException.java, BankAccount.java,
 *           Q10_BankingExample.java
 * Compile : javac *.java
 * Run     : java Q10_BankingExample
 */
import java.util.Scanner;

public class Q10_BankingExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Initial balance: " + account.getBalance());

        for (int i = 1; i <= 3; i++) {
            System.out.print("\nEnter amount to withdraw (attempt " + i + "/3): ");
            double amount = sc.nextDouble();
            try {
                account.withdraw(amount);
            } catch (InsufficientFundsException e) {
                System.out.println("User-defined exception caught: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Built-in exception caught: " + e.getMessage());
            }
        }
        sc.close();
        System.out.println("\nFinal balance: " + account.getBalance());
    }
}
