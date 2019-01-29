package com.thread.basic01.day03_state;

/**
 * 等待线程
 */
public class WaitRunnable implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s：开始执行，准备锁定object。\n", Thread.currentThread().getName());
        synchronized (Main.object) {
            System.out.printf("%s：成功锁定object。\n", Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                System.out.printf("%s：成功挂起，等待其他线程唤醒。\n", Thread.currentThread().getName());
                Main.object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s：成功被其他线程唤醒。\n", Thread.currentThread().getName());
        }
        System.out.printf("%s：执行完毕。\n", Thread.currentThread().getName());
    }
}
