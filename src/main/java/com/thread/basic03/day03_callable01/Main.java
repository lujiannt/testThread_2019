package com.thread.basic03.day03_callable01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 拓展-普通线程如何执行callable
 */
public class Main {
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator(10);
        //需要用到FutureTask类
        FutureTask<Integer> result = new FutureTask<>(calculator);
        new Thread(result, "test").start();

        while (!result.isDone()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("result is " + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
