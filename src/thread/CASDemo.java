package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.CAS是什么？ ==>Conmpare And Swap
 *  比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //compareAndSet第一个参数是期望值，第二个参数是更新值
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data : "+ atomicInteger.get());
        //修改失败
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data : "+ atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}
