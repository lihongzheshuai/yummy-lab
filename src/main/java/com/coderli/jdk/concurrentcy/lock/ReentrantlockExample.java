package com.coderli.jdk.concurrentcy.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrantlock样例
 *
 * @author li.hzh
 * @date 2016-03-31 21:55
 */
public class ReentrantlockExample {

    static int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void runExample() throws InterruptedException {
        int threadCount = 100;
        final int countTimesPerThread = 10000000;
        Thread[] ts = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {

                    lock.lock();
                    //从此开始是业务代码,上面相当于锁.
                    for (int j = 0; j < countTimesPerThread; j++) {
                        a++;
                    }
                    //业务代码结束, 通过CAS改回值(此处将state改为volatile变量亦可.)
                    lock.unlock();
                }
            });
        }
        for (int i = 0; i < threadCount; i++) {
            ts[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            ts[i].join();
        }
        System.err.println(threadCount * countTimesPerThread + " times count esult: " + a);
    }

    public static void main(String[] args) throws InterruptedException {
        new ReentrantlockExample().runExample();
    }
}


