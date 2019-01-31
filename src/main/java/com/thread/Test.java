package com.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();

        Thread.sleep(1000);

        ThreadPoolExecutor executor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(1, namedThreadFactory);
        executor1.execute(() -> {
            System.out.println("....test111....");
        });
        executor1.shutdown();

        ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        executor2.execute(() -> {
            System.out.println("....test222....");
        });
        executor2.shutdown();


        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
        System.out.println("|11|11|11|11|11|11|");
        System.out.println("|--|--|--|--|--|--|");
    }
}
