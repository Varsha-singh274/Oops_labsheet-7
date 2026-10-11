/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Intermediate - Packages
 *
 * Question 6 (a): Using import animals.Dog;
 *
 * Folder  : run the commands from inside Q06_ImportVsQualifiedName/
 * Compile : javac animals/Dog.java Q06_WithImport.java Q06_FullyQualified.java
 * Run     : java Q06_WithImport
 */
import animals.Dog;                    // import once, then use the short name

public class Q06_WithImport {
    public static void main(String[] args) {
        Dog obj = new Dog();           // short name
        obj.bark();
    }
}
