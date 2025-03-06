package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithFuture implements Callable<String> {
    public String call() {
        return "Exectuted  by "+Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(new CallableWithFuture());
        System.out.println(future.get());
        executor.shutdown();

    }
}
