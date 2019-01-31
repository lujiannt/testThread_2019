package com.thread.basic03.day12_rejectedExecution;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s is going to execute...\n", name);
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("%s finished execute...\n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
