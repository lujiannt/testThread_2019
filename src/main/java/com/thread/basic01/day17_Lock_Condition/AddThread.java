package com.thread.basic01.day17_Lock_Condition;

public class AddThread implements Runnable {
    private QueueBuffer queueBuffer;

    public AddThread(QueueBuffer queueBuffer) {
        this.queueBuffer = queueBuffer;
    }

    @Override
    public void run() {
        queueBuffer.add();
    }
}
