package com.thread.basic03.day02_poolSize;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    }

    public void executeTask(Task task) {
        executor.execute(task);

        //线程池中线程数
        System.out.println("线程池中线程数 : " + executor.getPoolSize());
        //线程池中正在执行的线程数
        System.out.println("线程池中正在执行的线程数 : " + executor.getActiveCount());
        //线程池中已完成的线程数
        System.out.println("线程池中已完成的线程数 : " + executor.getCompletedTaskCount());
    }

    public void shutDown() {
        executor.shutdown();
    }
}
