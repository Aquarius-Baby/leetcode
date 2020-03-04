package temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyPrint implements Runnable {

    private final int PRINT_COUNT = 10;
    private ReentrantLock reentrantLock;
    private Condition thisCondition;
    private Condition nextCondition;
    private char printChar;

    public MyPrint(ReentrantLock reentrantLock, Condition thisCondition, Condition nextCondition, char printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i + "   " + printChar);
                // 在调用await()方法前线程必须获得重入锁 ，
                // 调用await()方法后线程会释放当前占用的锁。
                // 同理在调用signal()方法时当前线程也必须获得相应重入锁，
                // 调用signal()方法后系统会从condition.await()等待队列中唤醒一个线程。
                // 当线程被唤醒后，它就会尝试重新获得与之绑定的重入锁，一旦获取成功将继续执行。
                // 所以调用signal()方法后一定要释放当前占用的锁，这样被唤醒的线程才能有获得锁的机会，才能继续执行。
                nextCondition.signal();
                if (i < PRINT_COUNT - 1) {
                    try {
                        thisCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();

        Thread printA = new Thread(new MyPrint(lock, conditionA, conditionB, 'A'));
        Thread printB = new Thread(new MyPrint(lock, conditionB, conditionA, 'B'));
        printA.start();
        Thread.sleep(1000);
        printB.start();
    }

}
