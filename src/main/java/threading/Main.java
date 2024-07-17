package threading;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            threads.add(new Thread(Test::getInstance));
        }
        for(Thread t: threads) {
            t.start();
        }
        for(Thread t: threads) {
            t.join();
        }
        new Test().test();
    }

    public static class Test {
        static int instance = 0;
        Test() {
            System.out.println(Math.random());
        }
        public static int getInstance() {
            if (instance != instance) {
                throw new AssertionError("as deep shit");
            }
            return instance++;
        }
        public void test() {

            synchronized (this) {

                synchronized (this) {
                    System.out.println("test");
                }
            }
        }
    }
}