package com.thread.basic01.day15_readWriteLock;

/**
 * 读写锁测试类
 */
public class Main {

    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        Thread[] writers = new Thread[5];
        Thread[] readers = new Thread[50];

        for (int i = 0; i < 50; i++) {
            try {
                readers[i] = new Thread(new Reader(priceInfo), "reader" + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            writers[i] = new Thread(new Writer(priceInfo), "wirter" + i);
        }

        for (int i = 0; i < 50; i++) {
            readers[i].start();
        }
        for (int i = 0; i < 5; i++) {
            writers[i].start();
        }

        //打印出线程的状态
        while (readers[49].getState() != Thread.State.TERMINATED
                || writers[4].getState() != Thread.State.TERMINATED) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s:%s, %s:%s \n", readers[49].getName(), readers[49].getState(),
                    writers[4].getName(), writers[4].getState());
        }
    }
}
