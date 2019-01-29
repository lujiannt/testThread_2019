package com.thread.basic01.day13_waitNotify;

/**
 * 生产者线程
 */
public class ProduceThread implements Runnable {
    private EventStorage store;

    public ProduceThread(EventStorage store) {
        this.store = store;
    }

    @Override
    public void run() {
        store.produce();
    }
}
