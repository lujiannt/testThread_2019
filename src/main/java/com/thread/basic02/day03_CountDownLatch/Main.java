package com.thread.basic02.day03_CountDownLatch;

/**
 * 并发等待测试类 https://my.oschina.net/nenusoul/blog/794634
 * 模拟场景：会议即将开始-等待所有人入场-所有人入场线程继续执行
 */
public class Main {
    public static void main(String[] args) {
        Meeting meeting = new Meeting();

        Thread meetingThread = new Thread(meeting);
        meetingThread.start();

        for (int i = 0; i < 10; i++) {
            Member member = new Member("会员" + i, meeting);
            Thread thread = new Thread(member);
            thread.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
