package com.thread.basic02.day03_CountDownLatch;

/**
 * 会员参与会议线程类
 */
public class Member implements Runnable {
    private String name;
    private Meeting meeting;

    public Member(String name, Meeting meeting) {
        this.name = name;
        this.meeting = meeting;
    }

    @Override
    public void run() {
        meeting.arrive(name);
    }
}
