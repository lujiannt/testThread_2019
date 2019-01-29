package com.thread.basic01.day15_readWriteLock;

import java.util.Date;

public class Reader implements Runnable {
    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        Date date = new Date();
        System.out.printf("%s read price1:%d time:%s\n", Thread.currentThread().getName(), priceInfo.getPrice1(), date);
        System.out.printf("%s read price2:%d time:%s\n", Thread.currentThread().getName(), priceInfo.getPrice2(), date);
    }
}
