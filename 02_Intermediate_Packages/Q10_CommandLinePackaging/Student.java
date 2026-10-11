/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 10: Packaging and compiling with directory structure (command-line)
 * Manually create a package college.students containing class Student.
 * Compile using  javac -d . Student.java
 * Write a main program in another file to access the class.
 * Run the program using  java college.students.Main
 *
 * Folder  : run the commands from inside Q10_CommandLinePackaging/
 * Step 1  : javac -d . Student.java      (creates college/students/Student.class)
 * Step 2  : javac -d . Main.java         (creates college/students/Main.class)
 * Step 3  : java college.students.Main
 *
 * The -d . option tells javac to create the package directory structure
 * (college/students/) automatically under the current directory (.).
 */
package college.students;

public class Student {
    private int rollNo;
    private String name;
    private String course;

    public Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Course  : " + course);
    }
}
