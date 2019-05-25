package com.thread.basic01.day18_reentarntLock_02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTr2 implements Runnable {
    ReentrantLock lock1;
    ReentrantLock lock2;

    public LockTr2(ReentrantLock lock1, ReentrantLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock2.tryLock();
        System.out.println("tr2...start");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (lock1.tryLock()) {
            System.out.println("tr2...end");
            lock1.unlock();
        } else {
            System.out.println("SyncTr1 获取lock1失败..");
        }

        lock2.unlock();
    }
}
