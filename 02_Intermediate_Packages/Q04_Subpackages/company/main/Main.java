/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 4: Subpackages (nested packages)
 * Create a package company.employees with a class Employee. Create another
 * program in package company.main that imports and uses the Employee class.
 *
 * Folder  : run the commands from inside Q04_Subpackages/
 * Compile : javac company/employees/Employee.java company/main/Main.java
 * Run     : java company.main.Main
 */
package company.main;

import company.employees.Employee;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee(101, "Rahul Sharma", 55000.50);
        e.display();
    }
}
