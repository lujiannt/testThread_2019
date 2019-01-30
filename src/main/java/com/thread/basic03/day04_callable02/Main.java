package com.thread.basic03.day04_callable02;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池执行器执行callable线程
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Future<Integer>> futures = new LinkedList<>();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int number = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);

            //执行callable的线程，使用submit可以接收返回值
            Future<Integer> future = executor.submit(calculator);
            futures.addLast(future);
        }

        //等待所有线程执行完毕
        while (executor.getCompletedTaskCount() < futures.size()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //输出所有线程计算结果
        for (int i = 0; i < futures.size(); i++) {
            Future<Integer> future = futures.get(i);
            try {
                System.out.println("result = " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
