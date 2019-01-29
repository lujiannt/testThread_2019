package com.thread.basic01.day06_guard;

import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 生产线程
 */
public class ProducerTask implements Runnable {
    private Deque<Event> deque;

    public ProducerTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event("event" + i, System.currentTimeMillis());
            deque.addFirst(event);
            System.out.printf("%s: 生产了一个event %s\n", Thread.currentThread().getName(), event.getEventName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
