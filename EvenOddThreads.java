package Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class EvenNumbers implements Runnable {
    private final BlockingQueue<Integer> queue;

    public EvenNumbers(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i <= 100; i += 2) {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class OddNumbers implements Runnable {
    private final BlockingQueue<Integer> queue;
    public OddNumbers(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class PrintNumbers implements Runnable {
    private final BlockingQueue<Integer> queue;

    public PrintNumbers(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Integer number = queue.take();
                System.out.println(number % 2 == 0 ? "Even: " + number : "Odd: " + number);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class EvenOddThreads {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Thread evenThread = new Thread(new EvenNumbers(queue));
        Thread oddThread = new Thread(new OddNumbers(queue));
        Thread printThread = new Thread(new PrintNumbers(queue));

        evenThread.start();
        oddThread.start();
        printThread.start();

        try {
            evenThread.join();
            oddThread.join();
            printThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
