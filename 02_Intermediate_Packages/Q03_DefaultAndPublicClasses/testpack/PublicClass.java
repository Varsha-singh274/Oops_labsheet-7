/*
 * Lab Sheet-07 | Question 3 (part 1 of 3): PUBLIC class in package testpack.
 * Public classes are visible to every package.
 */
package testpack;

public class PublicClass {
    public void show() {
        System.out.println("PublicClass.show(): accessible from any package.");
    }

    // A public class can still use a default class from its own package
    public void useHiddenClass() {
        HiddenClass h = new HiddenClass();
        h.show();
    }
}
