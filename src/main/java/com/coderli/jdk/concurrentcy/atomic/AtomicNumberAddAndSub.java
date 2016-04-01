package com.coderli.jdk.concurrentcy.atomic;

/**
 * @author li.hzh
 * @date 2016-03-29 14:12
 */
public class AtomicNumberAddAndSub {

    private static int numberOne = 0;

    public static void main(String[] args) throws InterruptedException {
        final int threadCount = 10;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Thread one = new Thread(new PlusRunner());
            threads[i] = one;
        }
//        for (Thread t : threads) {
//            t.start();
//        }
//        for (Thread t : threads) {
//            t.join();
//        }
        System.out.println("Result: " + numberOne);
    }

    static class PlusRunner implements Runnable {
        public void run() {
            for (int i = 0; i < 10000; i++) {
                numberOne++;
                System.out.println(Thread.currentThread().getName() + " Number: " + numberOne);
            }
        }
    }

}
