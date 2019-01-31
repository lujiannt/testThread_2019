package com.thread.basic03.day10_afterEnd;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Random random = new Random();
        int second = random.nextInt(10);
        TimeUnit.SECONDS.sleep(second);
        return "hello, i am " + name;
    }

    public String getName() {
        return name;
    }
}
