package com.thread.basic02.day05_phaser01;

import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {
        //构造函数参数表示线程数
        Phaser phaser = new Phaser(3);

        Thread thread1 = new Thread(new PhaserRunnable(phaser), "Thread-1");
        Thread thread2 = new Thread(new PhaserRunnable(phaser), "Thread-2");
        Thread thread3 = new Thread(new PhaserRunnable(phaser), "Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();

//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
