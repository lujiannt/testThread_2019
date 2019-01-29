package com.thread.basic01.day03_state;

/**
 * 线程状态测试类
 */
public class Main {
    public final static Object object = new Object();

    public static void main(String[] args) {
        Thread thread_wait = new Thread(new WaitRunnable());
        thread_wait.setName("Thread_wait");
        Thread thread_notify = new Thread(new NotifyRunnable());
        thread_notify.setName("thread_notify");

        System.out.printf("%s:%s, %s:%s \n", thread_wait.getName(), thread_wait.getState(),
                thread_notify.getName(), thread_notify.getState());

        //启动线程
        thread_wait.start();
        thread_notify.start();

        //打印出两个线程的状态
        while (thread_wait.getState() != Thread.State.TERMINATED
                || thread_notify.getState() != Thread.State.TERMINATED) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s:%s, %s:%s \n", thread_wait.getName(), thread_wait.getState(),
                    thread_notify.getName(), thread_notify.getState());
        }
    }

}
