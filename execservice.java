package Multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class execservice implements Runnable{
    @Override
    public void run() {
        System.out.println("Executor running"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i=0;i<5;i++) {
            executor.submit(new execservice());
        }
        executor.shutdown();
        //ExecutorService executor =  Executors.newFixedThreadPool(5);
    }
}
