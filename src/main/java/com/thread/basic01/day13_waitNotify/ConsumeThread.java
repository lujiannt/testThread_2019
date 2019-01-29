package com.thread.basic01.day13_waitNotify;

/**
 * 消费者线程
 */
public class ConsumeThread implements Runnable {
    private EventStorage store;

    public ConsumeThread(EventStorage store) {
        this.store = store;
    }

    @Override
    public void run() {
        store.consume();
    }
}
