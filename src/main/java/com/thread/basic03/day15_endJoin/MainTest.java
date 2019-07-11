package com.thread.basic03.day15_endJoin;

/**
 * 终止join测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Task_block task1 = new Task_block();
        Task_end task2 = new Task_end(Thread.currentThread());
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main stop...");
    }
}
