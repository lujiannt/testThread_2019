package com.thread.basic01.day13_waitNotify;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
    private int maxSize;
    private LinkedList<Date> list;

    public EventStorage() {
        this.maxSize = 10;
        this.list = new LinkedList<>();
    }

    /**
     * 生产一个对象
     */
    public void produce() {
        try {
            synchronized (Main.produceController) {
                //如果队列已满，调用wait方法，先释放对象锁，然后挂起当前线程到等待队列
                while (this.list.size() == this.maxSize) {
                    Main.produceController.wait();
                }

                list.add(new Date());
                System.out.printf("%s produce one, the size = %d\n", Thread.currentThread().getName(), this.list.size());
            }

            //当生产了Date后唤醒所有消费者线程
            synchronized (Main.consumeController) {
                Main.consumeController.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费一个对象
     */
    public void consume() {
        try {
            synchronized (Main.consumeController) {
                while (this.list.size() == 0) {
                    Main.consumeController.wait();
                }

                Thread.sleep(1000);

                System.out.printf("%s consume %s, the size = %d\n", Thread.currentThread().getName(), this.list.poll(), this.list.size());
            }

            //当消费后唤醒所有生产者线程
            synchronized (Main.produceController) {
                Main.produceController.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
