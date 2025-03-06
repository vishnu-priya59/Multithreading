package Multithreading;

public class Synchronization {
    private int count=0;

    public synchronized void increment(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Synchronization s = new Synchronization();
        Thread t1 = new Thread(s::increment);
        Thread t2 = new Thread(s::increment);

        t1.start();
        t2.start();
    }
}
