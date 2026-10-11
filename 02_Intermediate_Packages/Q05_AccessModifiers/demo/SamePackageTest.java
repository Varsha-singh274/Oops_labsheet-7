/*
 * Lab Sheet-07 | Question 5 (part 2 of 3): another class in the SAME package
 * (demo). public, protected and default members are accessible; private is not.
 */
package demo;

public class SamePackageTest {
    public static void test() {
        AccessDemo a = new AccessDemo();
        System.out.println("Same package -> public=" + a.publicVar
                + ", protected=" + a.protectedVar + ", default=" + a.defaultVar);
        a.publicMethod(); a.protectedMethod(); a.defaultMethod();
        // a.privateVar;  a.privateMethod();   // ERROR: has private access in AccessDemo
    }
}
