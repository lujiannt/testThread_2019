package com.thread.basic01.day14_reentrantLock;

public class JobThread implements Runnable {
    private PrintQueue printQueue;

    public JobThread(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s is going to print\n", Thread.currentThread().getName());
        printQueue.printJob();
        System.out.printf("%s has been printed\n", Thread.currentThread().getName());
    }
}
