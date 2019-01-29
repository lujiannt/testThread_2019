package com.thread.basic01.day09_threadGroup;

import java.util.concurrent.TimeUnit;

/**
 * 线程组测试类
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, new MyRunnable(i + 1), "Thread" + i);
            thread.start();

            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("group size is %d\n", threadGroup.activeCount());
        threadGroup.list();

        //创建一个线程数组存放线程组中线程
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.printf("%s : state is %s\n", threads[i].getName(), threads[i].getState());
        }

        //只执行第一个线程，其余的都中断
        while (threadGroup.activeCount() > 9) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadGroup.interrupt();
    }
}
