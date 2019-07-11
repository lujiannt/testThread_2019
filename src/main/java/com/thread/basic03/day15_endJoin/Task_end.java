package com.thread.basic03.day15_endJoin;

import java.util.concurrent.TimeUnit;

public class Task_end implements Runnable {
    private Thread thread_main;

    public Task_end(Thread thread_main) {
        this.thread_main = thread_main;
    }

    @Override
    public void run() {
        try {
            System.out.println("im task end");
            TimeUnit.SECONDS.sleep(3);
            if (thread_main != null) {
                thread_main.interrupt();
                System.out.println("主线程终止");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}