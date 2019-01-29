package com.thread.basic01.day05_interrupt;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s：开始执行\n", Thread.currentThread().getName());
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.printf("%s：被终止\n", Thread.currentThread().getName());
            e.printStackTrace();
        }
    }
}
