package com.thread.basic02.day01_Semaphore01;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PrintQueue {
    private Semaphore semaphore;

    public PrintQueue() {
        //默认是false 非公平锁
        this.semaphore = new Semaphore(1, true);
    }

    public void printInfo() {
        try {
            //获取信号量，如果没有则一直等待
            semaphore.acquire();

            Random random = new Random();
            long duration = random.nextInt(10) * 1000;
            Thread.sleep(duration);
            System.out.printf("%s print one, use %d seconds \n", Thread.currentThread().getName(), duration / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放信号量
            semaphore.release();
        }
    }
}
