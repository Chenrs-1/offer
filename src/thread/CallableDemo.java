package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
        int result01 = 100;
        System.out.println(Thread.currentThread().getName());
        int result02 = futureTask.get();

        System.out.println("result=" + (result01 + result02));
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        try{ TimeUnit.SECONDS.sleep(2); }catch (InterruptedException e){ e.printStackTrace(); }
        System.out.println("callable come in ...");

        return 1024;
    }
}
