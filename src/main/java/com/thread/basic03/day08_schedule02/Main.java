package com.thread.basic03.day08_schedule02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 周期性执行任务 https://my.oschina.net/nenusoul/blog/849160
 */
public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        Task task = new Task();
        //执行周期任务，每隔2秒执行一次
        executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        try {
            while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                Thread.sleep(500);
            }

            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
