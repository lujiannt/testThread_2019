package com.thread.basic03.day09_cancel;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private double d = 0.0;

    @Override
    public String call() {
//        while (true) {
//
//            System.out.println(Thread.currentThread().getName() + " is running...");
//            TimeUnit.MILLISECONDS.sleep(100);
//            Thread.yield();
//        }
        while (true) {
            try {
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("I am running!");
                }

                break;
//                TimeUnit.MILLISECONDS.sleThreadLocalep(100);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

        }
        System.out.println("thread is stop");
        return null;
    }
}
