package com.thread.basic03.day01_threadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task) {
        executor.execute(task);

        //线程池中线程数
        System.out.println("线程池中线程数 : " + executor.getPoolSize());
        //线程池中正在执行的线程数
        System.out.println("线程池中正在执行的线程数 : " + executor.getActiveCount());
        //线程池中已完成的线程数
        System.out.println("线程池中已完成的线程数 : " + executor.getCompletedTaskCount());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程池中已完成的线程数
        System.out.println("线程池中已完成的线程数 : " + executor.getCompletedTaskCount());
        executor.shutdown();
    }
}
