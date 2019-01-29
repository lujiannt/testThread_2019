package com.thread.basic01.day17_Lock_Condition;

/**
 * Lock condition测试类(同day13相比较)
 */
public class Main {
    public static void main(String[] args) {
        QueueBuffer queueBuffer = new QueueBuffer();

        AddThread produceThread = new AddThread(queueBuffer);
        GetThread consumeThread = new GetThread(queueBuffer);

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
