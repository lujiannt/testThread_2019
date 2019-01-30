package com.thread.basic03.day07_schedule01;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 延时任务测试类
 */
public class Main {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        for (int i = 1; i <= 5; i++) {
            Task task = new Task();
            //执行延时任务
            executor.schedule(task, i, TimeUnit.SECONDS);
        }

        try {
            executor.shutdown();

            //定时检测是否执行完
            if (!executor.awaitTermination(6, TimeUnit.SECONDS)) {
                System.out.println("还没结束");
            } else {
                System.out.println("已经结束");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
