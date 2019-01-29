package com.thread.basic01.day15_readWriteLock;

import java.util.Random;

public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        Random random = new Random();
        priceInfo.modifyPrice(random.nextInt(10), random.nextInt(10));
    }
}
