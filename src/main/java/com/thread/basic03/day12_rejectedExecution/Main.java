package com.thread.basic03.day12_rejectedExecution;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //创建执行器拒绝任务处理器
        RejectHandlerController rejectHandlerController = new RejectHandlerController();
        executor.setRejectedExecutionHandler(rejectHandlerController);

        for (int i = 0; i < 3; i++) {
            Task task = new Task("task" + i);
            executor.submit(task);
        }

        executor.shutdown();

        try {
            Thread.sleep(3000);

            //上面三个线程已经结束了，执行新任务时会触发执行器拒绝任务处理器
            Task task = new Task("RejectTask");
            executor.submit(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
