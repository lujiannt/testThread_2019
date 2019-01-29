package com.thread.basic02.day04_cyclicBarrier;

public class Last implements Runnable {
    private Result result;
    private int searchNumber;

    public Last(MatrixMox matrixMox, Result result, int searchNumber) {
        this.result = result;
        this.searchNumber = searchNumber;
    }

    @Override
    public void run() {
        int totalCount = 0;
        int[] data = result.getTotalCount();
        for (int i = 0; i < data.length; i++) {
            totalCount += data[i];
        }
        System.out.printf("最终找到%d个%d\n", totalCount, searchNumber);
    }
}
