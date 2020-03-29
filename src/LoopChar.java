public class LoopChar {
    /**
     * 创建三个线程,循环打印ABC
     */
    static class LoopI implements Runnable {

        private int id;
        private static int index = 1;
        private final int end = 30;
        private char[] ch = { 'A', 'B', 'C' };

        public LoopI(int id) {
            this.id = id;
        }
        public void run() {
            while (index <= end) {
                synchronized (Class.class) {
                    if ((index + 3 - 1) % 3 == id) {
                        System.out.print(ch[(index + 3 - 1) % 3]);
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
    public static void main(String[] args) throws InterruptedException {
        new Thread(new LoopI(0)).start();
        new Thread(new LoopI(1)).start();
        new Thread(new LoopI(2)).start();
    }
}
