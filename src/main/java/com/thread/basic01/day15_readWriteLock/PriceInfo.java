package com.thread.basic01.day15_readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {
    private int price1;
    private int price2;
    private ReadWriteLock lock;

    public PriceInfo() {
        this.price1 = 0;
        this.price2 = 0;
        this.lock = new ReentrantReadWriteLock();
    }

    /**
     * 修改价格
     *
     * @param price1
     * @param price2
     */
    public void modifyPrice(int price1, int price2) {
        //对同步数据进行修改时使用写锁，此时其他需要写锁的线程会被挂起，同时使用读锁的线程也会被挂起
        lock.writeLock().lock();
        System.out.printf("%s start modify price\n", Thread.currentThread().getName());
        this.price1 = price1;
        this.price2 = price2;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s modify price success\n", Thread.currentThread().getName());
        lock.writeLock().unlock();
    }

    /**
     * 读取价格1
     */
    public int getPrice1() {
        //使用读锁时，只与写操作互斥，读操作则可以并发(而synchronized 读与读也会互斥堵塞)
        lock.readLock().lock();
        int value = this.price1;
        lock.readLock().unlock();
        return value;
    }

    /**
     * 读取价格2
     */
    public int getPrice2() {
        lock.readLock().lock();
        int value = this.price2;
        lock.readLock().unlock();
        return value;
    }
}
