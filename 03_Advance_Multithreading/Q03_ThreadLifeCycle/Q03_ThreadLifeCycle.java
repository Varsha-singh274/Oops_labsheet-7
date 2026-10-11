/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 3: Explain and demonstrate the life cycle of a thread using a
 * Java program (New, Runnable, Running, Blocked, Terminated).
 *
 * Compile : javac Q03_ThreadLifeCycle.java
 * Run     : java Q03_ThreadLifeCycle
 *
 * LIFE CYCLE EXPLANATION
 * ----------------------
 *  NEW           : Thread object created but start() not yet called.
 *  RUNNABLE      : After start(). The thread is ready to run / is running.
 *                  (Java's Thread.State has one RUNNABLE state; the
 *                  textbook "Running" state is a RUNNABLE thread that the
 *                  scheduler has actually given the CPU to.)
 *  BLOCKED       : Thread is waiting to acquire a monitor lock held by
 *                  another thread (synchronized block/method).
 *  WAITING /     : Thread waits for another thread (wait(), join()) or for
 *  TIMED_WAITING   a fixed time (sleep(ms)). Also treated as "blocked/not
 *                  runnable" in the textbook model.
 *  TERMINATED    : run() has finished (or ended with an exception).
 *
 *   new Thread() --start()--> RUNNABLE <--> (scheduler: RUNNING)
 *                                |  lock busy      -> BLOCKED
 *                                |  sleep/wait/join -> WAITING / TIMED_WAITING
 *                                |  run() ends      -> TERMINATED
 */
public class Q03_ThreadLifeCycle {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();

        Thread t = new Thread(() -> {
            System.out.println("   [inside thread] state while running  : "
                    + Thread.currentThread().getState() + "   (RUNNING = RUNNABLE + has CPU)");
            synchronized (lock) {                       // blocked here while main holds the lock
                System.out.println("   [inside thread] got the lock, now sleeping 500 ms...");
                try { Thread.sleep(500); } catch (InterruptedException e) { }
            }
        }, "WorkerThread");

        // 1. NEW
        System.out.println("1. After creating the thread        : " + t.getState());

        synchronized (lock) {                           // main holds the lock
            // 2. RUNNABLE
            t.start();
            System.out.println("2. Immediately after start()        : " + t.getState());

            Thread.sleep(200);                          // give worker time to reach the lock
            // 3. BLOCKED
            System.out.println("3. Worker waiting for main's lock    : " + t.getState());
        }                                               // lock released here

        Thread.sleep(200);                              // worker is now inside sleep(500)
        // 4. TIMED_WAITING
        System.out.println("4. Worker inside Thread.sleep()      : " + t.getState());

        t.join();                                       // main waits for worker to finish
        // 5. TERMINATED
        System.out.println("5. After run() has completed         : " + t.getState());

        // Extra: WAITING state using wait()
        Thread w = new Thread(() -> {
            synchronized (lock) {
                try { lock.wait(); } catch (InterruptedException e) { }
            }
        }, "WaitingThread");
        w.start();
        Thread.sleep(200);
        System.out.println("6. Thread that called lock.wait()    : " + w.getState());
        synchronized (lock) { lock.notify(); }          // wake it up
        w.join();
        System.out.println("7. After notify() and completion     : " + w.getState());
    }
}
