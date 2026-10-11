/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 3: Package with default and public classes
 * Create a package testpack. Inside it, define one public class and one
 * non-public (default) class. Try accessing both from another program.
 * Observe what happens.
 *
 * Folder  : run the commands from inside Q03_DefaultAndPublicClasses/
 * Compile : javac testpack/*.java Q03_Main.java
 * Run     : java Q03_Main
 *
 * OBSERVATION
 * -----------
 *  - PublicClass can be imported and used from Q03_Main (another package).
 *  - HiddenClass cannot. If you un-comment the two lines marked (X) below,
 *    compilation fails with:
 *        error: HiddenClass is not public in testpack; cannot be accessed
 *               from outside package
 *  - A default (package-private) class is visible only to classes in the
 *    same package. However, PublicClass.useHiddenClass() can still use it
 *    internally because both classes belong to package testpack.
 */
import testpack.PublicClass;
// import testpack.HiddenClass;                  // (X) COMPILE ERROR if enabled

public class Q03_Main {
    public static void main(String[] args) {
        PublicClass p = new PublicClass();
        p.show();                       // works
        p.useHiddenClass();             // works: the hidden class is used inside the package

        // HiddenClass h = new HiddenClass();    // (X) COMPILE ERROR if enabled
        // h.show();
    }
}
