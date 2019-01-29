package com.thread.basic01.day01_basic;


import org.junit.Test;

/**
 * 线程基本测试类
 */
public class TestThread01_basic {

    /**
     * 每个线程使用单独的Runnable实现，每个线程都会执行5次，共执行15次
     */
    @Test
    public void test1() {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 所有线程公用一个Runnable实现，共执行5次
     */
    @Test
    public void test2() {
        Runnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
