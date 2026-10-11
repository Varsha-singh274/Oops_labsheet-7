/*
 * Lab Sheet-07 | Question 5 (part 1 of 3): class with all four kinds of
 * members, in package demo.
 */
package demo;

public class AccessDemo {
    public    int publicVar    = 1;
    protected int protectedVar = 2;
              int defaultVar   = 3;   // default (package-private)
    private   int privateVar   = 4;

    public    void publicMethod()    { System.out.println("public method"); }
    protected void protectedMethod() { System.out.println("protected method"); }
              void defaultMethod()   { System.out.println("default method"); }
    private   void privateMethod()   { System.out.println("private method"); }

    // Inside the same class everything is accessible
    public void testInsideClass() {
        System.out.println("Inside AccessDemo class -> all members accessible:");
        System.out.println(publicVar + " " + protectedVar + " " + defaultVar + " " + privateVar);
        publicMethod(); protectedMethod(); defaultMethod(); privateMethod();
    }
}
