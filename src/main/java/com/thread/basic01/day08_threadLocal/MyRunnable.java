package com.thread.basic01.day08_threadLocal;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return 3;
        }
    };


    @Override
    public void run() {
        while (threadLocal.get() > 0) {
            System.out.printf("%s: threadLocal:%s\n", Thread.currentThread().getName(), threadLocal.get());
            threadLocal.set(threadLocal.get() - 1);

            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
