package com.thread.basic03.day09_cancel;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 取消线程执行测试
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        Task task = new Task();
        Future<String> future = executor.submit(task);

        try {
            Thread.sleep(1000);
            //取消线程，如果填true表示执行中的线程也会中断
            future.cancel(true);
            System.out.println("isCancelled : " + future.isCancelled());
            System.out.println("isDone : " + future.isDone());

            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
