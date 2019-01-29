package com.thread.basic02.day06_phaser02;

import java.util.Random;
import java.util.concurrent.Phaser;

public class Student implements Runnable {
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        //student arrived
        System.out.printf("%s arrived\n", Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        //first exame
        System.out.printf("%s is going to do exam1\n", Thread.currentThread().getName());
        doExam1();
        System.out.printf("%s has been done exam1\n", Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        //second exame
        System.out.printf("%s is going to do exam2\n", Thread.currentThread().getName());
        doExam2();
        System.out.printf("%s has been done exam2\n", Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        //third exame
        System.out.printf("%s is going to do exam3\n", Thread.currentThread().getName());
        doExam3();
        System.out.printf("%s has been done exam3\n", Thread.currentThread().getName());
        phaser.arriveAndDeregister();
    }

    /**
     * 考试1
     */
    private void doExam1() {
        Random random = new Random();
        int ran = random.nextInt(10);
        try {
            Thread.sleep(ran * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 考试2
     */
    private void doExam2() {
        Random random = new Random();
        int ran = random.nextInt(10);
        try {
            Thread.sleep(ran * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 考试3
     */
    private void doExam3() {
        Random random = new Random();
        int ran = random.nextInt(10);
        try {
            Thread.sleep(ran * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
