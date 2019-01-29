package com.thread.basic01.day05_interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程终止测试类
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setName("Thread1");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s:开始终止线Thread1\n", Thread.currentThread().getName());
        thread.interrupt();
    }
}
