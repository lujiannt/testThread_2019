package com.thread.basic01.day10_synchronized01;


/**
 * synchronized测试
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000);
        Thread thread1 = new Thread(new MyRunnable(1000, account), "thread1");
        Thread thread2 = new Thread(new MyRunnable(-1000, account), "thread1");
        Thread thread3 = new Thread(new MyRunnable(-1000, account), "thread1");
        Thread thread4 = new Thread(new MyRunnable(-1000, account), "thread1");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //时间片让步，只要4个子线程没执行完毕，主线程就让步一直不执行，效果同join
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }

        System.out.printf("账户余额 ：" + account.getAmount());

    }
}
