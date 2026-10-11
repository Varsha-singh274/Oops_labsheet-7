/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Question 7 (part 1 of 2): user-defined exception class.
 */
public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
