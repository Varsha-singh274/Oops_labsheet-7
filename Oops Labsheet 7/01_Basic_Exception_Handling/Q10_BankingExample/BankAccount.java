/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Question 10 (part 2 of 3): BankAccount class.
 */
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            // built-in exception
            throw new IllegalArgumentException("Withdrawal amount cannot be negative: " + amount);
        }
        if (amount > balance) {
            // user-defined exception
            throw new InsufficientFundsException(
                "Insufficient funds! Balance = " + balance + ", requested = " + amount);
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount + ". Remaining balance = " + balance);
    }
}
