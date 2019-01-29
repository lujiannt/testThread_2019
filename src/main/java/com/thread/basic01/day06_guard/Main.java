package com.thread.basic01.day06_guard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 守护线程测试类
 */
public class Main {

    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();
        Thread produceThread1 = new Thread(new ProducerTask(deque), "ProduceThread1");
        Thread produceThread2 = new Thread(new ProducerTask(deque), "ProduceThread2");
        Thread produceThread3 = new Thread(new ProducerTask(deque), "ProduceThread3");

        produceThread1.start();
        produceThread2.start();
        produceThread3.start();

        Thread guardThread = new Thread(new GuardTask(deque), "GuardThread");
        //设置为守护线程，其他线程结束，守护线程也会结束
        guardThread.setDaemon(true);
        guardThread.start();

    }


}
