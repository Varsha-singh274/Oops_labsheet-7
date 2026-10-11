/*
 * Lab Sheet-07 | Question 10 (part 2 of 2): Main class that uses Student.
 * Both classes are in the same package college.students, so no import is
 * needed. Run with:  java college.students.Main
 */
package college.students;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(1, "Amit Kumar", "MCA");
        s.display();
    }
}
