/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 4: Create two threads that run simultaneously and print their own
 * names. Observe the output and explain thread scheduling.
 *
 * Compile : javac Q04_TwoThreadsScheduling.java
 * Run     : java Q04_TwoThreadsScheduling   (run it several times!)
 *
 * EXPLANATION OF THREAD SCHEDULING
 * --------------------------------
 *  - Both threads are RUNNABLE at the same time; the JVM thread scheduler
 *    (together with the OS) decides which thread gets the CPU and for how long.
 *  - Scheduling is not under the programmer's control and is not
 *    predictable. The order of lines can change on every run, e.g.
 *    Thread-A, Thread-B, Thread-A ... or Thread-A, Thread-A, Thread-B ...
 *  - On a multi-core CPU the two threads can really run in parallel; on a
 *    single core the CPU is time-sliced between them (concurrency).
 *  - Thread.sleep() is used here only to make the interleaving visible.
 */
class NamePrinter extends Thread {
    NamePrinter(String name) {
        super(name);                       // give the thread a name
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Running: " + getName() + "  (iteration " + i + ")");
            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }
    }
}

public class Q04_TwoThreadsScheduling {
    public static void main(String[] args) {
        NamePrinter t1 = new NamePrinter("Thread-A");
        NamePrinter t2 = new NamePrinter("Thread-B");
        t1.start();
        t2.start();
        System.out.println("main thread: both threads started, main continues independently.");
    }
}
