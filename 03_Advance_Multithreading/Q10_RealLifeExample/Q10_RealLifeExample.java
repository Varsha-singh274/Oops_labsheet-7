/*
 * Lab Sheet-07 | Object Oriented Programming Using Java | MCA III Semester
 * Section  : Advance - Multithreading
 *
 * Question 10: Write a Java program demonstrating a real-life example of
 * multithreading (e.g., downloading files, processing data, or printing
 * tasks) and explain each thread's role.
 *
 * Compile : javac Q10_RealLifeExample.java
 * Run     : java Q10_RealLifeExample
 *
 * SCENARIO: A download manager downloading three files at the same time.
 *
 * ROLE OF EACH THREAD
 * -------------------
 *  1. Downloader-1 (video.mp4, 5 parts)  : downloads the large video file.
 *  2. Downloader-2 (song.mp3,  3 parts)  : downloads the audio file.
 *  3. Downloader-3 (notes.pdf, 2 parts)  : downloads the small document.
 *     These three run CONCURRENTLY, so the small file finishes first instead
 *     of waiting for the big one (better responsiveness and utilisation).
 *  4. Reporter thread                    : after ALL downloads finish (it
 *     uses join()), it prints the final summary / report.
 *  5. main thread                        : creates and starts the threads and
 *     coordinates them.
 *  The shared TotalCounter is updated by all downloaders, so its methods are
 *  synchronized to avoid a race condition.
 */
class TotalCounter {
    private int totalParts = 0;
    public synchronized void add() { totalParts++; }
    public synchronized int get()  { return totalParts; }
}

class Downloader extends Thread {
    private final String fileName;
    private final int parts;
    private final int delayMs;
    private final TotalCounter counter;

    Downloader(String threadName, String fileName, int parts, int delayMs, TotalCounter counter) {
        super(threadName);
        this.fileName = fileName;
        this.parts = parts;
        this.delayMs = delayMs;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": started downloading " + fileName);
        for (int i = 1; i <= parts; i++) {
            try { Thread.sleep(delayMs); } catch (InterruptedException e) { }   // simulate network time
            counter.add();
            System.out.println(getName() + ": " + fileName + " -> part " + i + "/" + parts
                    + " (" + (i * 100 / parts) + "%)");
        }
        System.out.println(getName() + ": *** " + fileName + " download COMPLETE ***");
    }
}

public class Q10_RealLifeExample {
    public static void main(String[] args) throws InterruptedException {
        TotalCounter counter = new TotalCounter();

        Downloader d1 = new Downloader("Downloader-1", "video.mp4", 5, 400, counter);
        Downloader d2 = new Downloader("Downloader-2", "song.mp3", 3, 400, counter);
        Downloader d3 = new Downloader("Downloader-3", "notes.pdf", 2, 400, counter);

        Thread reporter = new Thread(() -> {
            try {
                d1.join(); d2.join(); d3.join();     // wait for all downloads
            } catch (InterruptedException e) { }
            System.out.println("\nReporter: All downloads finished.");
            System.out.println("Reporter: Total parts downloaded = " + counter.get() + " (expected 10)");
        }, "Reporter");

        System.out.println("main: starting download manager...\n");
        d1.start();
        d2.start();
        d3.start();
        reporter.start();

        reporter.join();
        System.out.println("main: download manager closed.");
    }
}
