package com.thread.basic03.day13_Thread_pool_excutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int coreSize = 10;
        int maxSize = 20;
        int keepAliveTime = 1;
        int blockSize = 5;

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Task-cancel-test").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize, maxSize, keepAliveTime,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(blockSize), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        Future<Integer> future = executor.submit(new Task());

        try {
            TimeUnit.SECONDS.sleep(2);
            future.cancel(true);
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
