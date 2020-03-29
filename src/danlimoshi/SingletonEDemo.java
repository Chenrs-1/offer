package danlimoshi;

public class SingletonEDemo {
    private static volatile SingletonEDemo instance = null;

    public SingletonEDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonEDemo()");
    }

    //单机安全，多线程，不安全，拿到了很多不同的实例
//    public static SingletonEDemo getInstance(){
//        if(instance == null){
//            instance = new SingletonEDemo();
//        }
//        return instance;
//    }
    /*//解决办法，加synchronized，但是这个方法，整个代码都锁了，重锁，不推荐
    public static synchronized SingletonEDemo getInstance(){
        if(instance == null){
            instance = new SingletonEDemo();
        }
        return instance;
    }*/

    //企业推荐使用DCL(Double Check Lock双端检锁机制),在加锁的前后都判断一次，
    //但是还有潜在的隐患，不一定线程安全，还有指令重排序的存在
    public static SingletonEDemo getInstance(){
        if(instance == null){
            synchronized(SingletonEDemo.class){
                if(instance == null){
                    instance = new SingletonEDemo();//这条语句可以分为3步，
                    //1.分配对象内存空间，memory = allocate();
                    //2.初始化对象，instance(memory);
                    //3.设置instance指向刚分配的内存地址，此时instance!=null
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

//        //单线程(main线程的操作动作)
//        System.out.println(SingletonEDemo.getInstance() == SingletonEDemo.getInstance());
//        System.out.println(SingletonEDemo.getInstance() == SingletonEDemo.getInstance());
//        System.out.println(SingletonEDemo.getInstance() == SingletonEDemo.getInstance());
//
//        System.out.println("---------------------");

        //并发多线程后，情况发生了很大的变化
        for(int i = 1;i <= 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonEDemo.getInstance();
                }
            },String.valueOf(i)).start();
        }
    }

}
