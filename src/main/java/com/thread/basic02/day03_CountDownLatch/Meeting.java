
package com.thread.basic02.day03_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 会议类
 */
public class Meeting implements Runnable {
    private CountDownLatch countDownLatch;

    public Meeting() {
        //CountDownLatch可以让线程等待其它线程完成一组操作后才能执行，否则就一直等待。
        //这个类使用一个整形参数来初始化，这个整形参数代表着等待其他线程的数量，
        //使用CountDownLatch.await()方法让线程开始等待其他线程执行完毕，
        //每一个线程执行完毕后后调用countDown()方法，这个方法会让CountDownLatch内部的计数器减1，
        //当计数器变为0的时候，CountDownLatch类将唤醒所有调用await()方法并进入WAITING状态线程。
        this.countDownLatch = new CountDownLatch(10);
    }

    public void arrive(String name) {
        countDownLatch.countDown();
        System.out.println(name + "到达会议");
        System.out.println("当前到会人数 : " + (10 - countDownLatch.getCount()));

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.printf("即将开始会议，当前到会人数:%d\n", 10 - countDownLatch.getCount());

        try {
            countDownLatch.await();
            System.out.println("人员到齐，开始会议！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
