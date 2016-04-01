package com.coderli.jdk.concurrentcy.happenbefore;

/**
 * 监视器法则+程序顺序法则理解代码
 * 加锁,仍会产生两种情况
 *
 * @author li.hzh
 * @date 2016-03-31 14:50
 */
public class FakeThreadSafeExample {

    static int a, b = 0;
    static int x, y = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (true) {
            count++;
            a = b = x = y = 0;
            Thread one = new Thread(new Runnable() {
//                @Override
                public void run() {
                    shortWait(100000);
                    b = 1; //1
                    synchronized (lock) {
                        x = a; //2
                    }
                }
            });

            Thread two = new Thread(new Runnable() {
//                @Override
                public void run() {
                    synchronized (lock) {
                        a = 1; //3
                    }
                    y = b; //4
                }
            });

            one.start();
            two.start();
            one.join();
            two.join();
//            if (y != 1) {
//                System.err.println("错了?");
//                System.exit(0);
//            }
            System.out.println("第" + count + "次: " + "(" + x + "," + y + ")");
            if ((x == 0 && y == 0) || (x == 1 && y == 1)) {
                System.err.println("是不是在逗我.");
                System.exit(0);
            }

        }
    }

    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
