package com.thread.basic02.day07_exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;

/**
 * 使用exchange，两个线程之间相互交换数据
 */
public class Main {
    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();

        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();

        Consumer consumer = new Consumer(buffer1, exchanger, phaser);
        Producer producer = new Producer(buffer2, exchanger, phaser);

        Thread thread1 = new Thread(consumer, "consumer");
        Thread thread2 = new Thread(producer, "producer");

        thread1.start();
        phaser.register();
        thread2.start();
        phaser.register();
    }
}
