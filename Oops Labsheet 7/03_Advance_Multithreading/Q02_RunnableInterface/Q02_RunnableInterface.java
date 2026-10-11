/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 2: Write a Java program to create a thread by implementing the
 * Runnable interface and display numbers from 1 to 10.
 *
 * Compile : javac Q02_RunnableInterface.java
 * Run     : java Q02_RunnableInterface
 *
 * Why Runnable? The class stays free to extend another class (Java has no
 * multiple inheritance), and the task is separated from the thread itself.
 */
class NumberTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }
}

public class Q02_RunnableInterface {
    public static void main(String[] args) {
        Thread t = new Thread(new NumberTask(), "NumberThread");
        t.start();
    }
}
