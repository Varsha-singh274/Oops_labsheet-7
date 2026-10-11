/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 6: Create a program where one thread sleeps for 2 seconds using
 * Thread.sleep() and another thread continues execution. Explain the
 * behavior.
 *
 * Compile : javac Q06_SleepMethod.java
 * Run     : java Q06_SleepMethod
 *
 * EXPLANATION
 * -----------
 *  Thread.sleep(2000) puts only the CURRENT thread into the TIMED_WAITING
 *  state for 2 seconds. It does not release any locks it holds, and it does
 *  not stop other threads. While SleepingThread is asleep, WorkingThread
 *  keeps executing normally. After 2 seconds SleepingThread becomes
 *  RUNNABLE again and continues from the next statement.
 */
public class Q06_SleepMethod {
    public static void main(String[] args) {

        Thread sleeper = new Thread(() -> {
            System.out.println("SleepingThread: going to sleep for 2 seconds...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("SleepingThread: interrupted!");
            }
            System.out.println("SleepingThread: woke up after 2 seconds!");
        }, "SleepingThread");

        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 8; i++) {
                System.out.println("WorkingThread : doing work step " + i);
                try { Thread.sleep(300); } catch (InterruptedException e) { }
            }
            System.out.println("WorkingThread : finished work.");
        }, "WorkingThread");

        sleeper.start();
        worker.start();
    }
}
