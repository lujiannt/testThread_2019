package com.thread.basic03.day05_callable03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 运行多个任务并处理第一个结果
 */
public class Main {

    public static void main(String[] args) {
        UserValid valid1 = new UserValid("valid-11");
        UserValid valid2 = new UserValid("valid-22");

        ValidTask task1 = new ValidTask(valid1);
        ValidTask task2 = new ValidTask(valid2);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<ValidTask> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);
        try {
            //invokeAny方法是核心，当所有线程都成功时，他会返回第一个结果；
            //当一个成功一个失败时，他会返回成功的结果;都失败时抛出异常
            String result = executor.invokeAny(list);

            while (executor.getCompletedTaskCount() != 2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%s result is %s", Thread.currentThread().getName(), result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
