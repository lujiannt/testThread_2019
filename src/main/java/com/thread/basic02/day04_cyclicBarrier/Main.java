package com.thread.basic02.day04_cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 并发等待测试类
 */
public class Main {
    public static void main(String[] args) {
        int row = 10000;
        int length = 10000;
        int searchNumber = 6;

        //构造矩阵类
        MatrixMox matrixMox = new MatrixMox(row, length, searchNumber);
        //构造结果类
        Result result = new Result(row);

        //创建所有线程执行完后，最终执行的线程
        Last last = new Last(matrixMox, result, searchNumber);
        //构造线程等待辅助类,参数1：等待的线程数  参数2：等待的线程执行完后要执行的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, last);

        for (int i = 0; i < 5; i++) {
            int firstRow = i * 2000;
            int lastRow = (i + 1) * 2000;
            Searcher searcher = new Searcher(matrixMox, result, firstRow, lastRow, searchNumber, cyclicBarrier);
            Thread thread = new Thread(searcher);
            thread.start();
        }
    }
}
