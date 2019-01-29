package com.thread.basic02.day04_cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
    private MatrixMox matrixMox;
    private Result result;
    private int firstRow;
    private int lastRow;
    private int searchNumber;
    private CyclicBarrier cyclicBarrier;

    public Searcher(MatrixMox matrixMox, Result result, int firstRow, int lastRow, int searchNumber, CyclicBarrier cyclicBarrier) {
        this.matrixMox = matrixMox;
        this.result = result;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.searchNumber = searchNumber;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.printf("%s 开始查询%d-%d行\n", Thread.currentThread().getName(), firstRow, lastRow);
        try {
            for (int i = firstRow; i < lastRow; i++) {
                int count = 0;
                int[] rowData = matrixMox.getRow(i);
                for (int j = 0; j < rowData.length; j++) {
                    if (searchNumber == rowData[j]) {
                        count++;
                    }
                }
                result.setRowCount(i, count);
            }

            System.out.printf("%s %d-%d行查询完毕\n", Thread.currentThread().getName(), firstRow, lastRow);

            //countDownLatch用countDown()方法计数器减一标记线程到达集合点，且不会阻塞
            //而cyclicBarrier用await方法标记线程到达集合点,且该线程会阻塞
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
