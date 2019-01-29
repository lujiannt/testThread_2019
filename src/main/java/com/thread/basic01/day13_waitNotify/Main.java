package com.thread.basic01.day13_waitNotify;

public class Main {
    public final static Object produceController = new Object();
    public final static Object consumeController = new Object();

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();

        ProduceThread produceThread = new ProduceThread(eventStorage);
        ConsumeThread consumeThread = new ConsumeThread(eventStorage);

        Thread[] producers = new Thread[20];
        Thread[] consumers = new Thread[20];

        for (int i = 0; i < 20; i++) {
            producers[i] = new Thread(produceThread, "producer" + i);
            consumers[i] = new Thread(consumeThread, "consumer" + i);
        }

        for (int i = 0; i < 20; i++) {
            producers[i].start();
            consumers[i].start();
        }
    }

}
