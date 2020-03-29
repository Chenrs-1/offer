package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 初始值为0的变量，两个线程交替操作，一个+1，一个-1，执行五轮
 * 1 线程  操作  资源类
 * 2 判断  干活  通知
 * 3 防止虚假唤醒机制
 */
public class ProdConsTradiDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();

        try{ TimeUnit.SECONDS.sleep(2); }catch (InterruptedException e){ e.printStackTrace(); }
        new Thread(new Runnable(){

            @Override
            public void run() {
                for(int i = 0;i < 5;i++){
                    try {
                        data.add();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"aaa").start();
        new Thread(new Runnable(){

            @Override
            public void run() {
                for(int i = 0;i < 5;i++){
                    try {
                        data.jian();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"bbb").start();
    }
}

class ShareData {//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //1 判断
            while (number != 0) {
                //等待，不能生产
                condition.await();
            }
            //2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //1 判断
            while (number == 0) {
                //等待，不能生产
                condition.await();
            }
            //2 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

//老版资源类
class Data{
    private int number = 0;
    private Lock lock = new ReentrantLock();

    public synchronized void add() throws Exception{

        while(number != 0){
            this.wait();
        }

        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
    public synchronized void jian() throws Exception{

        while(number == 0){
            this.wait();
        }

        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }

}
