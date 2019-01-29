package com.thread.basic01.day14_reentrantLock;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        JobThread jobThread = new JobThread(printQueue);

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(jobThread, "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
