package com.thread.basic03.day09_cancel;

import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 取消线程执行测试
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        Task task = new Task();
        FutureTask<String> futureTask = new FutureTask(task);
        Thread th = new Thread(futureTask, "T1");
        th.start();


//        Future<String> future = executor.submit(task);

        try {
            Thread.sleep(1000);
//            //取消线程，如果填true表示执行中的线程也会中断
//            future.cancel(true);
//            System.out.println("isCancelled : " + future.isCancelled());
//            System.out.println("isDone : " + future.isDone());
//
//            //不会关闭阻塞等待中的线程， 也不会关闭正在执行的线程，但会拒绝新的线程
//            executor.shutdown();

            //使用shutdownNow会关闭该线程池总所有线程
            //与cancel的区别：cancel只关闭具体的一个线程
//            executor.shutdownNow();
            //https://www.jianshu.com/p/bdf06e2c1541

            th.interrupt();
            System.out.println("已经interrupt");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
