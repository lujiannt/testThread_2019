package com.thread.basic01.day03_state;

/**
 * 唤醒线程
 */
public class NotifyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s：开始执行，准备锁定object。\n", Thread.currentThread().getName());
        synchronized (Main.object) {
            System.out.printf("%s：成功锁定object。\n", Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s：唤醒其他线程。\n", Thread.currentThread().getName());
            Main.object.notify();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s：执行完毕。\n", Thread.currentThread().getName());
    }
}
