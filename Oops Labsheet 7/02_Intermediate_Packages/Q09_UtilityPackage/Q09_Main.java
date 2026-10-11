/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 9: Create a utility package and reuse it
 * Create a package utils with a class MathUtils containing static methods:
 * add(), subtract(), multiply(). Import the package into another program and
 * call these methods.
 *
 * Folder  : run the commands from inside Q09_UtilityPackage/
 * Compile : javac utils/MathUtils.java Q09_Main.java
 * Run     : java Q09_Main
 */
import utils.MathUtils;

public class Q09_Main {
    public static void main(String[] args) {
        int x = 20, y = 8;
        // static methods are called with the class name - no object needed
        System.out.println("add(" + x + ", " + y + ")      = " + MathUtils.add(x, y));
        System.out.println("subtract(" + x + ", " + y + ") = " + MathUtils.subtract(x, y));
        System.out.println("multiply(" + x + ", " + y + ") = " + MathUtils.multiply(x, y));
    }
}
