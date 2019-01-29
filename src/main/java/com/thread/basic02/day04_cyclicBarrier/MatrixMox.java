package com.thread.basic02.day04_cyclicBarrier;

import java.util.Random;

public class MatrixMox {
    private int[][] data;

    public MatrixMox(int row, int length, int searchNumber) {
        int searchCount = 0;
        data = new int[row][length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < length; j++) {
                Random random = new Random();
                int value = random.nextInt(10);
                data[i][j] = value;

                if (searchNumber == value) {
                    searchCount++;
                }
            }
        }

        System.out.printf("构造矩阵时共产生searchNumber找到%d个%d\n", searchCount, searchNumber);
    }

    public int[] getRow(int row) {
        return data[row];
    }
}
