/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 9: Modify the previous program to use synchronized keyword or
 * synchronized method to handle thread synchronization and display correct
 * results.
 *
 * Compile : javac Q09_Synchronization.java
 * Run     : java Q09_Synchronization
 *
 * EXPLANATION
 * -----------
 *  A synchronized method (or block) acquires the object's monitor lock, so
 *  only ONE thread at a time can execute it. The read-add-write steps of
 *  count++ can no longer interleave, therefore no update is lost and the
 *  result is always exactly 5 x 10000 = 50000.
 */
class SafeCounter {
    private int count = 0;

    // Option 1: synchronized METHOD
    public synchronized void increment() {
        int temp = count;            // same read -> yield -> write steps as Q8,
        Thread.yield();              // but only ONE thread can be inside this
        count = temp + 1;            // method at a time, so no update is lost
    }

    public synchronized int getCount() {
        return count;
    }
}

class BlockCounter {
    private int count = 0;
    private final Object lock = new Object();

    // Option 2: synchronized BLOCK (locks only the critical section)
    public void increment() {
        synchronized (lock) {
            int temp = count;
            Thread.yield();
            count = temp + 1;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}

public class Q09_Synchronization {
    static final int THREADS = 5, INCREMENTS = 10000;

    public static void main(String[] args) throws InterruptedException {
        for (int round = 1; round <= 3; round++) {
            SafeCounter c1 = new SafeCounter();
            BlockCounter c2 = new BlockCounter();
            Thread[] threads = new Thread[THREADS];

            for (int i = 0; i < THREADS; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < INCREMENTS; j++) {
                        c1.increment();
                        c2.increment();
                    }
                });
                threads[i].start();
            }
            for (Thread t : threads) t.join();

            System.out.println("Round " + round + " -> Expected: " + (THREADS * INCREMENTS)
                    + " | synchronized method: " + c1.getCount()
                    + " | synchronized block: " + c2.getCount());
        }
    }
}
