package temp;

import java.util.concurrent.Semaphore;

/**
 * @Author: cmy
 * @Date: Created in  2021/4/23 5:11 下午
 * @Description:
 */

public class ThreadPrintAnt {
    static Semaphore a = new Semaphore(1);
    static Semaphore n = new Semaphore(1);
    static Semaphore t = new Semaphore(1);


    public static void main(String[] args) {
        try {
            n.acquire();
            t.acquire();
            ThreadA threadA = new ThreadA();
            ThreadN threadN = new ThreadN();
            ThreadT threadT = new ThreadT();
            threadA.start();
            threadN.start();
            threadT.start();
        } catch (Exception e) {

        } finally {

        }
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    a.acquire();
                    System.out.println("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    n.release();
                }
            }
        }
    }

    static class ThreadN extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    n.acquire();
                    System.out.println("n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    t.release();
                }
            }
        }
    }

    static class ThreadT extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    t.acquire();
                    System.out.println("t");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    a.release();
                }
            }
        }
    }
}


