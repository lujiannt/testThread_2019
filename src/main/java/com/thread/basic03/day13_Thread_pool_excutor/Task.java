package com.thread.basic03.day13_Thread_pool_excutor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getName() + " start run...");
        TimeUnit.SECONDS.sleep(7);
        System.out.println("Thread " + Thread.currentThread().getName() + " end run...");
        return 1;
    }
}
