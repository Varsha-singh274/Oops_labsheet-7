/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 7: Write a Java program that starts two threads where one thread
 * waits for another to finish using the join() method.
 *
 * Compile : javac Q07_JoinMethod.java
 * Run     : java Q07_JoinMethod
 *
 * EXPLANATION
 * -----------
 *  t1.join() makes the calling thread wait until t1 has terminated.
 *  Here "ProcessorThread" calls loader.join(), so it starts processing only
 *  after "LoaderThread" has completely finished loading. main() also joins
 *  both threads, so the final message is printed last.
 */
public class Q07_JoinMethod {
    public static void main(String[] args) throws InterruptedException {

        Thread loader = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("LoaderThread    : loading data part " + i + "/5");
                try { Thread.sleep(300); } catch (InterruptedException e) { }
            }
            System.out.println("LoaderThread    : loading COMPLETE.");
        }, "LoaderThread");

        Thread processor = new Thread(() -> {
            try {
                System.out.println("ProcessorThread : waiting for LoaderThread to finish...");
                loader.join();                      // wait here until loader terminates
            } catch (InterruptedException e) { }
            System.out.println("ProcessorThread : data loaded, processing started...");
            for (int i = 1; i <= 3; i++) {
                System.out.println("ProcessorThread : processing step " + i + "/3");
                try { Thread.sleep(200); } catch (InterruptedException e) { }
            }
            System.out.println("ProcessorThread : processing COMPLETE.");
        }, "ProcessorThread");

        loader.start();
        processor.start();

        loader.join();
        processor.join();
        System.out.println("main            : both threads finished. Program ends.");
    }
}
