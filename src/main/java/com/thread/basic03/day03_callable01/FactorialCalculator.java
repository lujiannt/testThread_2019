package com.thread.basic03.day03_callable01;

import java.util.concurrent.Callable;

/**
 * 阶乘计算线程
 */
public class FactorialCalculator implements Callable {
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (number >= 2) {
            System.out.printf("%s number is %d\n", Thread.currentThread().getName(), number);
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
