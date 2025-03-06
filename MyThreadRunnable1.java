package Multithreading;

public class MyThreadRunnable1 implements Runnable{
    @Override
    public void run() {
        System.out.println("I'm in thread 1");
    }
}
class MyThreadRunnable2 implements Runnable{

    @Override
    public void run() {
        System.out.println("I'm in thread2");
    }
}
class main{
    public static void main(String[] args) {
        MyThreadRunnable1 runnable1=new MyThreadRunnable1();
        MyThreadRunnable2 runnable2=new MyThreadRunnable2();

        Thread t1= new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
    }
}

/*we can also extends Thread class */