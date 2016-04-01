package com.coderli.jdk.concurrentcy.atomic;

/**
 * @author li.hzh
 * @date 2016-03-29 13:13
 */
public class NoThreadSafeNumberAddAndSub {

    private static int numberOne = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread plusThread = new Thread(new PlusRunner());
        Thread subThread = new Thread(new SubRunner());
        plusThread.start();
        subThread.start();
        plusThread.join();
        subThread.join();
        long end = System.currentTimeMillis();
        System.out.println("Result: " + numberOne);
        System.out.println("Time: " + (end - start) + "ms");
    }


    static class PlusRunner implements Runnable {
        public void run() {
            for (int i = 0; i < 100000; i++) {
                numberOne++;
                System.out.println(Thread.currentThread().getName() + " Number: " + numberOne);
            }
        }
    }

    static class SubRunner implements Runnable {
        public void run() {
            for (int i = 0; i < 100000; i++) {
                numberOne--;
                System.out.println(Thread.currentThread().getName() + " Number: " + numberOne);
            }
        }
    }

}
