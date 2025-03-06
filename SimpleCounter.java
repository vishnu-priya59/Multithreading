package Multithreading;

public class SimpleCounter {
    static int count=0;

    void increment(){
        count++;
    }
    void decrement(){
        count--;
    }

    public static void main(String[] args) {
        SimpleCounter counter = new SimpleCounter();
        counter.increment();
        counter.increment();
        counter.decrement();
        System.out.println(count);
    }


}
