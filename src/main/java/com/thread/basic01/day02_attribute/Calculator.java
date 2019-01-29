package com.thread.basic01.day02_attribute;

public class Calculator implements Runnable {
    private int num;

    public Calculator() {
        super();
    }

    public Calculator(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.printf("%s : %d * %d = %d\n",
                        Thread.currentThread().getName(), i, num, i * num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
