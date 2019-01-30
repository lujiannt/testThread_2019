package com.thread.basic03.day06_invokeAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("task" + i);
            tasks.add(task);
        }

        try {
            List<Future<Result>> futures = executor.invokeAll(tasks);

            while (executor.getCompletedTaskCount() != 100) {
                Thread.sleep(100);
            }

            for (Future<Result> future : futures) {
                try {
                    Result result = future.get();
                    System.out.println(result.getName() + " " + result.getValue());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
