package com.thread.basic02.day05_phaser01;

import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaserRunnable implements Runnable {
    private Phaser phaser;

    public PhaserRunnable(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        //表示已经进入执行状态
        System.out.println("task start .............");
        phaser.arriveAndAwaitAdvance();

        //第一阶段
        try {
            System.out.printf("%s start step1\n", Thread.currentThread().getName());
            Random random = new Random();
            int step1Second = random.nextInt(10);
            Thread.sleep(step1Second * 1000);
            System.out.printf("%s over step1 and take %d second\n", Thread.currentThread().getName(), step1Second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //表示第一阶段执行完毕，进入等待状态，直到所有其他线程也都第一阶段执行完毕
        phaser.arriveAndAwaitAdvance();

        //第二阶段
        try {
            System.out.printf("%s start step2\n", Thread.currentThread().getName());
            Random random = new Random();
            int step2Second = random.nextInt(10);
            Thread.sleep(step2Second * 1000);
            System.out.printf("%s over step2 and take %d second\n", Thread.currentThread().getName(), step2Second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //表示第二阶段执行完毕，进入等待状态，直到所有其他线程也都第二阶段执行完毕
        phaser.arriveAndAwaitAdvance();

        //第三阶段
        try {
            System.out.printf("%s start step3\n", Thread.currentThread().getName());
            Random random = new Random();
            int step3Second = random.nextInt(10);
            Thread.sleep(step3Second * 1000);
            System.out.printf("%s over step3 and take %d second\n", Thread.currentThread().getName(), step3Second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //表示第三阶段执行完毕，进入等待状态，直到所有其他线程也都第三阶段执行完毕，结束任务
        System.out.println("task end .............");
        phaser.arriveAndDeregister();
    }
}
