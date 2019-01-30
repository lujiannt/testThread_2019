package com.thread.basic02.day07_exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;

public class Consumer implements Runnable {
    private Phaser phaser;
    private List<String> buffer;
    private Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger, Phaser phaser) {
        this.buffer = buffer;
        this.exchanger = exchanger;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        System.out.printf("step1： %s buffer size is %d\n", Thread.currentThread().getName(), buffer.size());
        phaser.arriveAndAwaitAdvance();

        try {
            buffer = exchanger.exchange(buffer);
            System.out.printf("step2： %s buffer size is %d\n", Thread.currentThread().getName(), buffer.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
    }
}
