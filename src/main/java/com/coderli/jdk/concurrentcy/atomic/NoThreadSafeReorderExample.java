package com.coderli.jdk.concurrentcy.atomic;

/**
 * 非线程安全重排序的例子
 *
 * @author li.hzh
 * @date 2016-03-30 14:26
 */
public class NoThreadSafeReorderExample {

    static int a, b = 0;
    static int x, y = 0;

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
                    x = a; //2
                }
            });

            Thread two = new Thread(new Runnable() {
//                @Override
                public void run() {
                    a = 1; //3
                    y = b; //4
                }
            });

            one.start();
            two.start();
            one.join();
            two.join();
            System.out.println("第" + count + "次: " + "(" + x + "," + y + ")");
            if (x == 0 && y == 0) {
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
