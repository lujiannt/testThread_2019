package com.thread.basic01.day04_children;

/**
 * 子线程结束测试类
 */
public class Main {

    public static void main(String[] args) {
        System.out.printf("%s:开始执行\n", Thread.currentThread().getName());

        Thread thread1 = new Thread(new MyRunnable());
        thread1.setName("Thread1");
        Thread thread2 = new Thread(new MyRunnable());
        thread2.setName("Thread1");
        thread1.start();
        thread2.start();

        //主线程会先于子线程结束，通过下面的子线程的join方法使主线程转成waiting状态,
        // 这样主线程会等待子线程完成后再结束
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s:结束执行\n", Thread.currentThread().getName());

    }
}
