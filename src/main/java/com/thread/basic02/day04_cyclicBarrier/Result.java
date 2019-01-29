package com.thread.basic02.day04_cyclicBarrier;

public class Result {
    private int[] data;

    public Result(int size) {
        data = new int[size];
    }

    public void setRowCount(int row, int count) {
        data[row] = count;
    }

    public int[] getTotalCount() {
        return data;
    }
}
