package com.thread.basic02.day07_exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;

public class Producer implements Runnable {
    private Phaser phaser;
    private List<String> buffer;
    private Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger, Phaser phaser) {
        this.buffer = buffer;
        this.exchanger = exchanger;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        for (int i = 0; i < 10; i++) {
            String event = "event" + i;
            buffer.add(event);
        }
        System.out.printf("step1： %s buffer size is %d\n", Thread.currentThread().getName(), buffer.size());
        phaser.arriveAndAwaitAdvance();

        try {
            //exchange方法相当于一个同步点，将会一直等待交换数据的另外一个线程也到达exchange方法，
            buffer = exchanger.exchange(buffer);
            System.out.printf("step2： %s buffer size is %d\n", Thread.currentThread().getName(), buffer.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
    }
}
