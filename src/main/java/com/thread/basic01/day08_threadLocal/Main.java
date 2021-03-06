package com.thread.basic01.day08_threadLocal;


/**
 * 每个线程独有局部变量ThreadLocal测试
 */
public class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        Thread thread3 = new Thread(runnable, "Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();

        MyRunnable2 runnable2 = new MyRunnable2();
        Thread thread4 = new Thread(runnable2, "Thread-4");
        Thread thread5 = new Thread(runnable2, "Thread-5");
        Thread thread6 = new Thread(runnable2, "Thread-6");
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
