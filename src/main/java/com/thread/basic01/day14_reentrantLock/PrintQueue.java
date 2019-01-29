package com.thread.basic01.day14_reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final static ReentrantLock lock = new ReentrantLock();

    public void printJob() {
        try {
            lock.lock();
            System.out.printf("%s print success\n", Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //一定要解锁，否则会死锁
            lock.unlock();
        }

    }
}
