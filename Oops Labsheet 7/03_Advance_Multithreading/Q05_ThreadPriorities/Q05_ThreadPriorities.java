/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 5: Write a program to set different thread priorities
 * (MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY) and observe which thread
 * executes first.
 *
 * Compile : javac Q05_ThreadPriorities.java
 * Run     : java Q05_ThreadPriorities   (run it several times!)
 *
 * OBSERVATION
 * -----------
 *  MIN_PRIORITY = 1, NORM_PRIORITY = 5 (default), MAX_PRIORITY = 10.
 *  A higher priority is only a HINT to the scheduler. Usually the
 *  MAX_PRIORITY thread gets more CPU time and tends to finish earlier, but
 *  there is NO guarantee, because the behaviour depends on the OS and the
 *  JVM. Do not rely on priorities for correctness.
 */
class PriorityTask extends Thread {
    PriorityTask(String name) { super(name); }

    @Override
    public void run() {
        long sum = 0;
        for (int i = 1; i <= 3; i++) {
            for (long j = 0; j < 200_000_000L; j++) { sum += j; }    // CPU work
            System.out.println(getName() + " (priority " + getPriority() + ") finished round " + i);
        }
    }
}

public class Q05_ThreadPriorities {
    public static void main(String[] args) {
        PriorityTask low  = new PriorityTask("LOW-thread ");
        PriorityTask norm = new PriorityTask("NORM-thread");
        PriorityTask high = new PriorityTask("HIGH-thread");

        low.setPriority(Thread.MIN_PRIORITY);     // 1
        norm.setPriority(Thread.NORM_PRIORITY);   // 5
        high.setPriority(Thread.MAX_PRIORITY);    // 10

        System.out.println("MIN = " + Thread.MIN_PRIORITY + ", NORM = " + Thread.NORM_PRIORITY
                + ", MAX = " + Thread.MAX_PRIORITY);
        // start the lowest first, to show that start order does not decide the winner
        low.start();
        norm.start();
        high.start();
    }
}
