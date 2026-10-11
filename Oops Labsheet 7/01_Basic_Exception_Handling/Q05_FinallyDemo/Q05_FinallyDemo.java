/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 5: finally block demonstration
 * Write a program that opens a resource (e.g., message "File opened"),
 * performs some operation, and always prints "Resource closed" in a finally
 * block - even if an exception occurs.
 *
 * Compile : javac Q05_FinallyDemo.java
 * Run     : java Q05_FinallyDemo
 */
public class Q05_FinallyDemo {

    // Simulates opening a file, doing work and closing it.
    static void processFile(String name, boolean causeError) {
        System.out.println("---- Processing: " + name + " ----");
        try {
            System.out.println("File opened");
            System.out.println("Performing operation on the file...");
            if (causeError) {
                int x = 10 / 0;        // deliberately cause an exception
                System.out.println("This line is never reached: " + x);
            }
            System.out.println("Operation completed successfully.");
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Resource closed");   // ALWAYS printed
        }
        System.out.println();
    }

    public static void main(String[] args) {
        processFile("data1.txt (no error)", false);
        processFile("data2.txt (with error)", true);
    }
}
