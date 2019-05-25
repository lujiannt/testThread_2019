package com.thread.basic01.day18_reentarntLock_02;

import java.util.concurrent.TimeUnit;

public class SyncTr1 implements Runnable {
    String lock1;
    String lock2;

    public SyncTr1(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("fun1...start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("fun1...end");
            }
        }
    }
}
