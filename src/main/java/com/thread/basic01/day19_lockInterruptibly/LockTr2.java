package com.thread.basic01.day19_lockInterruptibly;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTr2 implements Runnable {
    private ReentrantLock lock;

    public LockTr2(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            while (true && !Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("im t2, im running");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
