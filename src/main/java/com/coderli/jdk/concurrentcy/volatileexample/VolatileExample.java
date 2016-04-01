package com.coderli.jdk.concurrentcy.volatileexample;

/**
 * Volatile语义样例
 *
 * @author li.hzh
 * @date 2016-03-30 21:12
 */
public class VolatileExample {

    static int a, b = 0;
    static volatile boolean flag = false;
    static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            count++;
            a = b = 0;
            flag = false;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    shortWait(100000);
                    a = 1; //1
                    flag = true; //2
                }
            });

            Thread two = new Thread(new Runnable() {
                public void run() {
                    if (flag) { //3
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
