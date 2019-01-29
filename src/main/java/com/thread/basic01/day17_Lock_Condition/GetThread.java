package com.thread.basic01.day17_Lock_Condition;

public class GetThread implements Runnable {
    private QueueBuffer queueBuffer;

    public GetThread(QueueBuffer queueBuffer) {
        this.queueBuffer = queueBuffer;
    }

    @Override
    public void run() {
        queueBuffer.get();
    }
}
