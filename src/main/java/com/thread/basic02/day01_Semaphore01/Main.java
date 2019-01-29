package com.thread.basic02.day01_Semaphore01;

/**
 * 信号量测试类
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Job(printQueue), "Thread" + i);
            thread.start();
        }
    }
}
