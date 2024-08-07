package threading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Test(0, 3));
        Thread t2 = new Thread(new Test(1, 3));
        Thread t3 = new Thread(new Test(2, 3));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    public static class Test implements Runnable {
        public static int counter = 0;
        public static final Object o = new Object();

        public final int threadNumber;
        public final int totalThreads;

        public Test(int threadNumber, int totalThreads) {
            this.threadNumber = threadNumber;
            this.totalThreads = totalThreads;
        }

        @Override
        public void run() {
            try {
                while (counter <= 10) {
                    synchronized (o) {
                        while (counter % totalThreads != threadNumber) {
                            o.wait();
                        }
                        System.out.println(counter +" "+ Thread.currentThread().getName());
                        counter++;
                        o.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}