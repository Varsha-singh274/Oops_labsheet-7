/*
 * Lab Sheet-07 | Question 2 (part 1 of 3): class Circle in package shapes.
 */
package shapes;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
