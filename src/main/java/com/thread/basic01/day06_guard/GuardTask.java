package com.thread.basic01.day06_guard;

import java.util.Deque;

/**
 * 守护线程,确保生产的每一个event都是5秒内的
 */
public class GuardTask implements Runnable {
    private Deque<Event> deque;

    public GuardTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            Event event = deque.getLast();
            if (System.currentTimeMillis() - event.getCreateTimeStamp() > 5000) {
                deque.removeLast();
                System.out.printf("%s: 移除event %s,队列长度为 %d\n", Thread.currentThread().getName(), event.getEventName(), deque.size());
            }
        }
    }
}
