package com.thread.basic01.day19_lockInterruptibly;

import java.util.concurrent.TimeUnit;

public class SyncTr1 implements Runnable {
    private Object condition;

    public SyncTr1(Object condition) {
        this.condition = condition;
    }

    @Override
    public void run() {
        synchronized (condition) {
            while (true) {
                try {
                    System.out.println("im tr2, im running");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
