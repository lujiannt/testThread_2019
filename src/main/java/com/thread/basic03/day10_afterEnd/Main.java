package com.thread.basic03.day10_afterEnd;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            Task task = new Task("task" + i);
            ResultTask resultTask = new ResultTask(task);
            executor.submit(resultTask);

            if (i == 1) {
                resultTask.cancel(true);
            }

            try {
                if (!resultTask.isCancelled()) {
                    System.out.println(resultTask.get());
                }

                if (i == 2) {
                    executor.shutdown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
