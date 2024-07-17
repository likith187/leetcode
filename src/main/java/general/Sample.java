package general;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
//        AtomicInteger i = new AtomicInteger(1);
        int n = 10;
        Helper h = new Helper(3);
        Runnable r = () -> {
            while (h.i.get() < 10) {
                try {
                    h.increment(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t = new Thread(r);
        Thread t2 = new Thread(() -> {
            while (h.i.get() < 10) {
                try {
                    h.increment(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (h.i.get() < 10) {
                try {
                    h.increment(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        t2.start();
        t3.start();
        System.out.println(t.getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());
        t.join();
        t2.join();
        t3.join();
    }

    public static class Helper {
        private int currentThread;
        private final int maxThreads;
        private final AtomicInteger i = new AtomicInteger(0);

        public Helper(int maxThreads) {
            this.maxThreads = maxThreads;
            this.currentThread = 0;
        }


        public synchronized void increment(int value) throws InterruptedException {
            while (currentThread != value) {
                System.out.println(currentThread + " " +value);
                wait();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
            i.incrementAndGet();
            currentThread++;
            currentThread = currentThread % maxThreads;
            System.out.println(currentThread);
            notify();
        }
    }
}
