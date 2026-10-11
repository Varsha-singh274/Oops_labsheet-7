/*
 * Lab Sheet-07 | Question 3 (part 2 of 3): NON-PUBLIC (default / package-private)
 * class in package testpack. It is visible only inside package testpack.
 */
package testpack;

class HiddenClass {            // no 'public' keyword -> default access
    void show() {
        System.out.println("HiddenClass.show(): only accessible inside package testpack.");
    }
}
