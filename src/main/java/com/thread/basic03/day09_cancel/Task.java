package com.thread.basic03.day09_cancel;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true) {
            System.out.println("task is running...");
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
