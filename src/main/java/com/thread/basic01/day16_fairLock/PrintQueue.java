package com.thread.basic01.day16_fairLock;

import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    //使用true作为参数就可以创建一个公平锁，使用公平锁时锁会选择等待时间最长的一个线程。
    private final static ReentrantLock lock = new ReentrantLock(true);

    public void printJob() {
        try {
            lock.lock();
            System.out.printf("%s print success\n", Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //一定要解锁，否则会死锁
            lock.unlock();
        }

    }
}
