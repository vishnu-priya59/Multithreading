package Multithreading;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger count = new AtomicInteger(0);
    void increment(){
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.increment();
        System.out.println(c.count);
    }
}
