/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 8: Create a program where multiple threads access a shared
 * counter variable. Without synchronization, show incorrect results.
 *
 * Compile : javac Q08_RaceCondition.java
 * Run     : java Q08_RaceCondition   (result differs on every run)
 *
 * EXPLANATION
 * -----------
 *  count++ is NOT atomic. It is three steps: read count, add 1, write back.
 *  When two threads interleave these steps they may both read the same old
 *  value, so one increment is lost. This is a RACE CONDITION and the final
 *  value is usually less than the expected one (5 threads x 10000 = 50000).
 */
class Counter {
    private int count = 0;

    public void increment() {        // NOT synchronized
        // This is exactly what  count++  does internally: read -> add -> write.
        // Thread.yield() is added only to give other threads a chance to run
        // between the read and the write, so the problem becomes visible on
        // EVERY machine (single-core or multi-core) and in EVERY run.
        int temp = count;            // 1. read
        Thread.yield();              //    (another thread may run here)
        count = temp + 1;            // 2 + 3. add one and write back
    }

    public int getCount() {
        return count;
    }
}

public class Q08_RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        final int THREADS = 5, INCREMENTS = 10000;

        for (int round = 1; round <= 3; round++) {
            Counter counter = new Counter();
            Thread[] threads = new Thread[THREADS];

            for (int i = 0; i < THREADS; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < INCREMENTS; j++) {
                        counter.increment();
                    }
                });
                threads[i].start();
            }
            for (Thread t : threads) t.join();    // wait for all threads

            System.out.println("Round " + round + " -> Expected: " + (THREADS * INCREMENTS)
                    + ", Actual: " + counter.getCount()
                    + (counter.getCount() == THREADS * INCREMENTS ? "" : "   <-- INCORRECT (race condition)"));
        }
    }
}
