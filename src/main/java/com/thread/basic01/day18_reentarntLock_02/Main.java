package com.thread.basic01.day18_reentarntLock_02;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试死锁，
 * 测试锁的重入性，
 * tryLock的使用
 */
public class Main {
    private static ReentrantLock lock = new ReentrantLock();

    //可重入简单理解就是当锁已经被一个方法或对象获取了，仍然可以获取这把锁进行锁操作。
    //但是注意：仅限于同一个类或对象中

    @Test
    public void test1() {
        String lock1 = "lock1";
        String lock2 = "lock2";

        //都在本对象内测试 无死锁，说明synchronized具有可重入性
        Main main = new Main();
        main.fun1(lock1, lock2);
        main.fun2(lock1, lock2);
    }


    @Test
    public void test2() {
        String lock1 = "lock1";
        String lock2 = "lock2";

        //在不同对象测试,使用Synchronized关键字，发现有死锁
        Thread t1 = new Thread(new SyncTr1(lock1, lock2));
        Thread t2 = new Thread(new SyncTr2(lock1, lock2));
        t1.start();
        t2.start();
    }

    @Test
    public void test3() {
        //在不同对象测试,使用ReentrantLock，发如果只用lock()发现有死锁，
        //使用tryLock没有死锁
        ReentrantLock lock_1 = new ReentrantLock();
        ReentrantLock lock_2 = new ReentrantLock();
        Thread t1 = new Thread(new LockTr1(lock_1, lock_2));
        Thread t2 = new Thread(new LockTr2(lock_1, lock_2));
        t1.start();
        t2.start();
    }

    private void fun1(String lock1, String lock2) {
        synchronized (lock1) {
            System.out.println("fun1...start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("fun1...end");
            }
        }
    }


    private void fun2(String lock1, String lock2) {
        synchronized (lock2) {
            System.out.println("fun2...start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("fun2...end");
            }
        }
    }
}
