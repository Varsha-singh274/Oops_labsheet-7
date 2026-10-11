/*
 * Lab Sheet-07 | Question 2 (part 2 of 3): class Rectangle in package shapes.
 */
package shapes;

public class Rectangle {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}
