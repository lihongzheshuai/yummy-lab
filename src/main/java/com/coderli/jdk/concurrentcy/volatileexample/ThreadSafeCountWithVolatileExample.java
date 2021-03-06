package com.coderli.jdk.concurrentcy.volatileexample;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 利用CAS和volatile实现的锁的功能
 *
 * @author li.hzh
 * @date 2016-03-31 21:55
 */
public class ThreadSafeCountWithVolatileExample {

    static int a = 0;
    private volatile int state;
    private static final Unsafe unsafe = getUnsafe();
    private static long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (ThreadSafeCountWithVolatileExample.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            return (Unsafe) singleoneInstanceField.get(null);

        } catch (Exception e) {
        }
        return null;
    }

    public boolean casState(int expect, int val) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, val);
    }

    public void runExample() throws InterruptedException {
        int threadCount = 100;
        final int countTimesPerThread = 10000000;
        Thread[] ts = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (; ; ) {
                        boolean lockState = casState(0, 1);
                        if (lockState) {
                            break;
                        }
                    }
                    //从此开始是业务代码,上面相当于锁.
                    for (int j = 0; j < countTimesPerThread; j++) {
                        a++;
                    }
                    //业务代码结束, 通过CAS改回值(此处将state改为volatile变量亦可.)
//                    casState(1, 0);
                    state = 0;
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
        new ThreadSafeCountWithVolatileExample().runExample();
    }
}


