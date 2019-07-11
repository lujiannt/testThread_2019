package com.thread.basic01.day08_threadLocal;

import java.util.concurrent.TimeUnit;

public class MyRunnable2 implements Runnable {
    private int value = 3;


    @Override
    public void run() {
        this.value -= 1;
        System.out.println(Thread.currentThread().getName() + " : " + value);
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
