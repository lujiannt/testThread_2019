package com.thread.basic01.day17_Lock_Condition;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueBuffer {
    private int maxSize;
    private LinkedList<Date> list;
    private Lock lock;
    private Condition addCondition;
    private Condition getCondition;

    public QueueBuffer() {
        this.maxSize = 10;
        this.list = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.addCondition = lock.newCondition();
        this.getCondition = lock.newCondition();
    }

    public void add() {
        //condition一定要在锁里面
        lock.lock();

        try {
            while (list.size() == maxSize) {
                //await使当前线程释放lock,挂起当前线程，到等待队列中
                addCondition.await();
            }

            list.add(new Date());
            System.out.printf("%s add one, size = %d\n", Thread.currentThread().getName(), list.size());

            //signal使线程从等待队列到同步队列，直至获取到lock继续执行
            getCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        //condition一定要在锁里面
        lock.lock();

        try {
            while (list.size() == 0) {
                getCondition.await();
            }
            list.poll();
            System.out.printf("%s poll one, size = %d\n", Thread.currentThread().getName(), list.size());

            addCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
