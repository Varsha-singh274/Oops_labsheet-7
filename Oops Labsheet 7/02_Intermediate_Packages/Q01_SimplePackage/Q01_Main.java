/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 1: Create and use a simple user-defined package
 * Create a package named mypack containing a class Hello with a method
 * display(). In another program, import the package and call the method.
 *
 * Folder  : run the commands from inside Q01_SimplePackage/
 * Compile : javac mypack/Hello.java Q01_Main.java
 * Run     : java Q01_Main
 */
import mypack.Hello;

public class Q01_Main {
    public static void main(String[] args) {
        Hello h = new Hello();
        h.display();
    }
}
