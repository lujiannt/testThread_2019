package com.thread.basic01.day18_reentarntLock_02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTr1 implements Runnable {
    ReentrantLock lock1;
    ReentrantLock lock2;

    public LockTr1(ReentrantLock lock1, ReentrantLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock1.tryLock();
        System.out.println("tr1...start");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (lock2.tryLock()) {
            System.out.println("tr1...end");
            lock2.unlock();
        } else {
            System.out.println("Tr1 获取lock2失败..");
        }

        lock1.unlock();
    }

}
