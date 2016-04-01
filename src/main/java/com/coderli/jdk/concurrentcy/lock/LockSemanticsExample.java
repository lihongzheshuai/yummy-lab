package com.coderli.jdk.concurrentcy.lock;

/**
 * @author li.hzh
 * @date 2016-04-01 12:17
 */
public class LockSemanticsExample {

    static int a, b = 0;
    static int count = 0;
    static boolean flag = false;
    static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            count++;
            a = b = 0;
            flag = false;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    shortWait(100000);
                    a = 1; //1
//                    synchronized (lock) {
                    flag = true;
//                    }
                }
            });

            Thread two = new Thread(new Runnable() {
                public void run() {
                    synchronized (lock) {
                    }
                    if (flag) {
                        b = a; //4
                        System.out.println("第" + count + "次: b=" + b);
                        if (b == 0) {
                            System.exit(0);
                        }
                    }
                }
            });
            one.start();
            two.start();
            one.join();
            two.join();
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
