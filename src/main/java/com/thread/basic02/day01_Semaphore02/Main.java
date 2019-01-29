package com.thread.basic02.day01_Semaphore02;

/**
 * 信号量测试类 https://my.oschina.net/nenusoul/blog/794419
 */
public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Job(printQueue), "Thread" + i);
            thread.start();
        }
    }
}
