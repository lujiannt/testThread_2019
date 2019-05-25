package com.thread.basic01.day18_reentarntLock_02;

import java.util.concurrent.TimeUnit;

public class SyncTr2 implements Runnable {
    String lock1;
    String lock2;

    public SyncTr2(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("fun2...start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("fun2...end");
            }
        }
    }
}
