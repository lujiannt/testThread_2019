package com.thread.basic03.day06_invokeAll;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<Result> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        Result result = null;

        try {
            Random random = new Random();
            int sleep = random.nextInt(10);
            Thread.sleep(sleep * 1000);

            int value = sleep;
            result = new Result(name, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
