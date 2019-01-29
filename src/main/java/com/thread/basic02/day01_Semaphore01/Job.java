package com.thread.basic02.day01_Semaphore01;

public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s is going to print\n", Thread.currentThread().getName());
        printQueue.printInfo();
        System.out.printf("%s end print\n", Thread.currentThread().getName());
    }
}
