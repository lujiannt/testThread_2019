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
    }
}
