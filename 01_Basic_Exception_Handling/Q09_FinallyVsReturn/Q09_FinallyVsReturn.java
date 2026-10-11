/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Basic - Exception Handling
 *
 * Question 9: Finally vs Return
 * Write a method with a try block that returns a value. Use a finally block
 * to print a message. Observe and explain which block is executed first.
 *
 * Compile : javac Q09_FinallyVsReturn.java
 * Run     : java Q09_FinallyVsReturn
 *
 * EXPLANATION
 * -----------
 * When the 'return' statement in the try block is reached:
 *   1. The return expression is evaluated and its value is saved.
 *   2. The finally block is executed BEFORE control leaves the method.
 *   3. Only after finally completes does the method actually return the
 *      saved value to the caller.
 * So the order of execution is:  try block -> finally block -> return to caller.
 * Changing the variable inside finally does NOT change the already-saved
 * return value (for primitives), as shown in test() below.
 * (If finally itself has a 'return', it overrides the try's return value -
 * this is bad practice and shown only for understanding.)
 */
public class Q09_FinallyVsReturn {

    static int test() {
        int x = 10;
        try {
            System.out.println("1. Inside try block, returning x = " + x);
            return x;                       // value 10 is saved here
        } finally {
            x = 99;                         // does not affect the saved value
            System.out.println("2. Inside finally block (executes BEFORE method returns), x = " + x);
        }
    }

    @SuppressWarnings("finally")
    static int overrideDemo() {
        try {
            return 1;
        } finally {
            return 2;                       // overrides the try's return value
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demo 1: return in try + message in finally ===");
        int value = test();
        System.out.println("3. Back in main(), method returned: " + value);

        System.out.println();
        System.out.println("=== Demo 2: return inside finally overrides try's return ===");
        System.out.println("overrideDemo() returned: " + overrideDemo());

        System.out.println();
        System.out.println("Conclusion: try runs first, then finally, then the value is returned.");
    }
}
