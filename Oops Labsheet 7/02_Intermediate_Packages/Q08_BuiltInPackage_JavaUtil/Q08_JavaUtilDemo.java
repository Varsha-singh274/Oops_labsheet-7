/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 8: Using Java built-in package (java.util)
 * Write a program that uses ArrayList and Scanner classes from java.util
 * package. Demonstrate how system packages are imported and used.
 *
 * Compile : javac Q08_JavaUtilDemo.java
 * Run     : java Q08_JavaUtilDemo
 *
 * NOTE: java.lang (String, System, Math ...) is imported automatically.
 * Every other built-in package such as java.util must be imported.
 */
import java.util.ArrayList;     // import a single class
import java.util.Scanner;       // import another class from the same package
// import java.util.*;          // alternative: import the whole package

public class Q08_JavaUtilDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("How many names do you want to enter? ");
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name " + i + ": ");
            names.add(sc.nextLine());
        }

        System.out.println("\nNames stored in the ArrayList:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
        System.out.println("Total names : " + names.size());
        System.out.println("List        : " + names);
        sc.close();
    }
}
