import java.util.Scanner;

public class demo {

    static class LoopI implements Runnable {

        private int id;
        static int n;
        private static int index = 1;

        public LoopI(int id) {
            this.id = id;
        }
        public void run() {
            while (index <= n) {
                synchronized (Class.class) {
                    if (index == id) {
                        System.out.println(Thread.currentThread().getName()+"线程 打印 结果="+id);
                        index++;
                        Class.class.notifyAll();
                    } else {
                        try {
                            Class.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.valueOf(s.next());
        LoopI.n = n;
        for (int i = 1; i <= n; i++) {
            new Thread(new LoopI(i)).start();
        }
    }
}
