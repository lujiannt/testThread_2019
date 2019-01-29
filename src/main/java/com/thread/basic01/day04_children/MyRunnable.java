package com.thread.basic01.day04_children;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s：开始执行\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep((long) Math.random() * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s：结束执行\n", Thread.currentThread().getName());
    }
}
