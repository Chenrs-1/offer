package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    //int number=0;
    volatile int number=0;

    public void setTo60(){
        this.number=60;
    }

    //此时number前面已经加了volatile，但是不保证原子性
    public void addPlusPlus(){
        number++;
    }
//    //方法一：加锁保证原子性，但不推荐
//    public synchronized void addPlusPlus1(){
//        number++;
//    }

    AtomicInteger atomicInteger=new AtomicInteger();//原子包装的整型类，初始值0
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

public class VolatileDemo {

    public static void main(String[] args) {
        volatileVisibilityDemo();//可见性测试
        atomicDemo();//原子性测试
    }

    private static void atomicDemo() {
        System.out.println("原子性测试");
        MyData myData=new MyData();

        //匿名类创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //System.out.println("我是匿名类创建的线程");
            }
        },Thread.currentThread().getName()).start();


        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            //线程让步。顾名思义，就是说当一个线程使用了这个方法之后，
            //它就会把自己CPU执行的时间让掉，让自己或者其它的线程运行，
            // 注意是让自己或者其他线程运行，并不是单纯的让给其他线程
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t int type finally number value: "+myData.number);

        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type finally number value: "+myData.atomicInteger);
    }

    //volatile可以保证可见性，及时通知其它线程主物理内存的值已被修改
    private static void volatileVisibilityDemo() {
        System.out.println("可见性测试");
        MyData myData=new MyData();//资源类
        //启动一个线程操作共享数据
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.setTo60();
                System.out.println(Thread.currentThread().getName()+"\t update number value: "+myData.number);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        },"AAA").start();

        while (myData.number==0){
            //main线程持有共享数据的拷贝，一直为0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over. main get number value: "+myData.number);
    }
}


