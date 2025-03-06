package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ScatterGather {
    public static void main(String[] args) throws Exception {
        ExecutorService executor= Executors.newFixedThreadPool(3);
        Future<Integer> future1 = executor.submit(new Task(2));
        Future<Integer> future2 = executor.submit(new Task(3));
        Future<Integer> future3 = executor.submit(new Task(4));

        int result = future1.get()+future2.get()+future3.get();
        System.out.println(result);

        executor.shutdown();
    }
}
class Task implements Callable<Integer>{
    private int num;

    public Task(int num){
        this.num=num;
    }
    public Integer call(){
        return num*num;
    }
}