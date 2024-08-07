package threading;

public class NumberPrinter implements Runnable {
    private static final int MAX_COUNT = 10;
    private static int currentNumber = 1;
    private int threadId;
    private static final Object lock = new Object();
    private static int currentThreadId = 1;

    public NumberPrinter(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (currentNumber <= MAX_COUNT) {
            synchronized (lock) {
                while (threadId != currentThreadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }

//                if (currentNumber <= MAX_COUNT) {
                    System.out.println("Thread " + threadId + ": " + currentNumber);
                    currentNumber++;
                    currentThreadId = currentThreadId % 3 + 1;
//                }
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new NumberPrinter(1));
        Thread t2 = new Thread(new NumberPrinter(2));
        Thread t3 = new Thread(new NumberPrinter(3));

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
