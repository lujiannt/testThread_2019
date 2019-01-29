package com.thread.basic02.day06_phaser02;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        //此处未配置线程数,在下面使用register动态注册
        Phaser phaser = new MyPhaser();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Student(phaser), "student" + i);
            //动态配置pahser的线程数
            phaser.register();
            thread.start();
        }
    }
}
