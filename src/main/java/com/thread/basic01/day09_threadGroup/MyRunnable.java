package com.thread.basic01.day09_threadGroup;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {
    private int num;

    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            long sleepSecond = (long) (num * 20);
            System.out.printf("%s start sleep %d\n", Thread.currentThread().getName(), sleepSecond);
            TimeUnit.SECONDS.sleep(sleepSecond);
        } catch (InterruptedException e) {
            System.out.printf("%s is interrupted\n", Thread.currentThread().getName());
            e.printStackTrace();
            return;
        }
        System.out.printf("%s end\n", Thread.currentThread().getName());
    }
}
