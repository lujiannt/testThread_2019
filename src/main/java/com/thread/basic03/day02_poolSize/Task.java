package com.thread.basic03.day02_poolSize;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s is going to excute task\n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has been excuted task\n", Thread.currentThread().getName());
    }
}
