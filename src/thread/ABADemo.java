package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {//ABA问题的解决  AtomicStampedReference

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);//原子引用
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);//原子时间戳引用，第一个参数，初始化的值，第二个是时间戳(版本号)

    public static void main(String[] args) {
        System.out.println("======ABA问题的产生======");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                //暂停1秒线程t2线程，保证上面的t1线程完成了一次ABA操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get().toString());
        }, "t2").start();

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("======ABA问题的解决======");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();//先拿到版本号
            System.out.println(Thread.currentThread().getName() + "\t第一次版本号： " + stamp);
            try {
                //暂停1秒t3线程
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101, atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t第二次版本号： " + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101,100, atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t第三次版本号： " + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第一次版本号： " + stamp);
            try {
                //暂停1秒线程线程t4线程，保证上面的t3线程完成了一次ABA操作
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result=atomicStampedReference.compareAndSet(100,2019, stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t修改成功与否："+result+"  当前最新版本号"+atomicStampedReference.getStamp());

            System.out.println(Thread.currentThread().getName()+"\t当前实际值："+atomicStampedReference.getReference());
        }, "t4").start();
    }
}