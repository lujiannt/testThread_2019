package com.thread.basic03.day15_endJoin;

import java.util.concurrent.TimeUnit;

public class Task_block implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("im task block");
            TimeUnit.SECONDS.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
