package com.thread.basic01.day16_fairLock;

public class JobThread implements Runnable {
    private PrintQueue printQueue;

    public JobThread(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        printQueue.printJob();
    }
}
