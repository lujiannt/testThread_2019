package com.thread.basic01.day07_catchException;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        Integer.parseInt("A");
    }
}
