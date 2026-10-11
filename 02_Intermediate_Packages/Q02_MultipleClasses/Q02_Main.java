/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 2: Package with multiple classes
 * Create a package shapes containing two classes: Circle and Rectangle, each
 * having an area() method. Import the package and calculate the area of both
 * shapes in another class.
 *
 * Folder  : run the commands from inside Q02_MultipleClasses/
 * Compile : javac shapes/*.java Q02_Main.java
 * Run     : java Q02_Main
 */
import shapes.Circle;
import shapes.Rectangle;

public class Q02_Main {
    public static void main(String[] args) {
        Circle c = new Circle(7);
        Rectangle r = new Rectangle(10, 5);

        System.out.printf("Area of Circle (radius 7)          = %.2f%n", c.area());
        System.out.printf("Area of Rectangle (10 x 5)         = %.2f%n", r.area());
    }
}
