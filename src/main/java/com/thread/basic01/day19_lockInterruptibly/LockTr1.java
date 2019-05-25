package com.thread.basic01.day19_lockInterruptibly;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTr1 implements Runnable {
    private ReentrantLock lock;

    public LockTr1(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
            lock.unlock();
        }
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("im tr1, im running");
        }


    }
}
