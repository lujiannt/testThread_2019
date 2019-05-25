package com.thread.basic01.day19_lockInterruptibly;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试lockInterruptibly
 */
public class Main {

    /**
     * 测试sync对应线程中断的反应
     */
    @Test
    public void test1() {
        Object condition = new Object();
        Thread t1 = new Thread(new SyncTr1(condition));
        Thread t2 = new Thread(new SyncTr2(condition));
        t1.start();
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //当t1获取到锁后，t2将会一直处于等待状态，即使中断也没用
        t2.interrupt();
    }


    /**
     * 测试lockInterruptibly
     */
    @Test
    public void test2() {
        try {
            ReentrantLock lock = new ReentrantLock();
            Thread t1 = new Thread(new LockTr1(lock));
            Thread t2 = new Thread(new LockTr2(lock));
            t1.start();

            TimeUnit.SECONDS.sleep(2);
            t2.start();
            TimeUnit.SECONDS.sleep(2);

            //使用通常的lock()，当t1获取到锁后，t2将会一直处于等待状态，即使中断也没用
            //使用lockInterruptibly， t2将会抛出异常
            t2.interrupt();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
