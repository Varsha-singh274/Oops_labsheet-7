/*
 * Lab Sheet-07 | Question 4 (part 1 of 2): class Employee in sub-package
 * company.employees.
 */
package company.employees;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : " + salary);
    }
}
