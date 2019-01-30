package com.thread.basic03.day08_schedule02;

import java.util.Date;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s run and date is %s\n", Thread.currentThread().getName(), new Date());
    }
}
