package com.thread.basic01.day01_basic;

public class MyRunnable implements Runnable {
    private int num = 5;

    @Override
    public void run() {
        while (num > 0) {
            System.out.println("Thread:" + Thread.currentThread().getName() + "  num:" + num);
            num--;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
