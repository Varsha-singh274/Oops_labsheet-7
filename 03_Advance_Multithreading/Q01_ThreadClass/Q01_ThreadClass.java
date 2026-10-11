/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 1: Write a Java program to create a thread by extending the
 * Thread class and display a message five times.
 *
 * Compile : javac Q01_ThreadClass.java
 * Run     : java Q01_ThreadClass
 */
class MessageThread extends Thread {
    @Override
    public void run() {                       // code executed by the new thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Message " + i + " from " + getName() + ": Hello, I am a thread!");
        }
    }
}

public class Q01_ThreadClass {
    public static void main(String[] args) {
        MessageThread t = new MessageThread();
        t.start();                            // start() creates the thread and calls run()
        // t.run() would NOT create a new thread - it would run like a normal method call
    }
}
