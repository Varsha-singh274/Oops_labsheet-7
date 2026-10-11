/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 5: Access modifiers in packages
 * Create a package demo with a class having public, protected, default, and
 * private members. Write another class (outside the package) and test which
 * members are accessible.
 *
 * Folder  : run the commands from inside Q05_AccessModifiers/
 * Compile : javac demo/*.java other/AccessTest.java
 * Run     : java other.AccessTest
 *
 * RESULT TABLE (accessibility from OUTSIDE package demo)
 * ------------------------------------------------------------------
 * Modifier    Same class   Same package   Subclass (other pkg)   Other pkg
 * public         yes           yes               yes                yes
 * protected      yes           yes               yes (inheritance)  NO
 * default        yes           yes               NO                 NO
 * private        yes           NO                NO                 NO
 * ------------------------------------------------------------------
 */
package other;

import demo.AccessDemo;
import demo.SamePackageTest;

public class AccessTest {

    // A subclass in a different package CAN use protected members (via inheritance)
    static class Child extends AccessDemo {
        void testInherited() {
            System.out.println("Subclass in other package -> public=" + publicVar
                    + ", protected=" + protectedVar);
            publicMethod();
            protectedMethod();                   // OK through inheritance
            // System.out.println(defaultVar);   // ERROR: not public in AccessDemo
            // System.out.println(privateVar);   // ERROR: private access
        }
    }

    public static void main(String[] args) {
        AccessDemo obj = new AccessDemo();

        System.out.println("=== 1. Inside the class itself ===");
        obj.testInsideClass();

        System.out.println("\n=== 2. Another class in the same package (demo) ===");
        SamePackageTest.test();

        System.out.println("\n=== 3. Subclass in a different package ===");
        new Child().testInherited();

        System.out.println("\n=== 4. Non-subclass in a different package (this class) ===");
        System.out.println("public variable    : " + obj.publicVar);   // OK
        obj.publicMethod();                                            // OK

        // The following lines cause COMPILE ERRORS, so they are commented out:
        // System.out.println(obj.protectedVar);  // protectedVar has protected access in demo.AccessDemo
        // obj.protectedMethod();                 // protectedMethod() has protected access in demo.AccessDemo
        // System.out.println(obj.defaultVar);    // defaultVar is not public in demo.AccessDemo; cannot be accessed from outside package
        // obj.defaultMethod();                   // defaultMethod() is not public in demo.AccessDemo; cannot be accessed from outside package
        // System.out.println(obj.privateVar);    // privateVar has private access in demo.AccessDemo
        // obj.privateMethod();                   // privateMethod() has private access in demo.AccessDemo
        System.out.println("protected / default / private members are NOT accessible here.");
    }
}
