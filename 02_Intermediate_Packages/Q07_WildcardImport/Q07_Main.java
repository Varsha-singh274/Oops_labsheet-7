/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 7: Using import package.* (wildcard import)
 * Create multiple classes (e.g., A, B, C) in package mypackage. Use
 * import mypackage.*; and access all classes in a single program.
 *
 * Folder  : run the commands from inside Q07_WildcardImport/
 * Compile : javac mypackage/*.java Q07_Main.java
 * Run     : java Q07_Main
 *
 * NOTE: import mypackage.*; imports all classes of that package (not the
 * classes of its sub-packages). It does not slow down the program - it only
 * tells the compiler where to look for class names.
 */
import mypackage.*;

public class Q07_Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        a.show();
        b.show();
        c.show();
    }
}
