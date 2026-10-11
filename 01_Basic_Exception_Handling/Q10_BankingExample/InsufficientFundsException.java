/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Question 10 (part 1 of 3): user-defined exception.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
