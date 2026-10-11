/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 6 (b): Using the fully qualified name
 *                 animals.Dog obj = new animals.Dog();
 *
 * Run     : java Q06_FullyQualified
 *
 * COMPARISON: import vs fully qualified name
 * ------------------------------------------------------------------
 * import animals.Dog;                | animals.Dog obj = new animals.Dog();
 * -----------------------------------|-----------------------------------
 * Written once at the top of file    | Written every time the class is used
 * Code is shorter and more readable  | Code is longer, more verbose
 * Short class name used afterwards   | Package name always visible
 * Cannot import two classes with the | Needed when two classes with the same
 * same simple name (name clash)      | name come from different packages,
 *                                    | e.g. java.util.Date vs java.sql.Date
 * Best for normal use                | Best for one-time use or resolving clashes
 * ------------------------------------------------------------------
 * Both approaches produce the same result; they differ only in style.
 */
public class Q06_FullyQualified {
    public static void main(String[] args) {
        animals.Dog obj = new animals.Dog();   // no import statement required
        obj.bark();
    }
}
