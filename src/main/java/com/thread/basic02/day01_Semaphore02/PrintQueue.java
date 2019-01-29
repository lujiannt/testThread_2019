package com.thread.basic02.day01_Semaphore02;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PrintQueue {
    private boolean[] printers;
    private Lock printLock;
    private Semaphore semaphore;

    public PrintQueue() {
        printers = new boolean[]{true, true, true};
        printLock = new ReentrantLock();
        semaphore = new Semaphore(3);
    }

    public void printInfo() {
        try {
            System.out.println("-----------------" + semaphore.availablePermits());
            //获取信号量
            semaphore.acquire();
            //获取可用打印机
            int printNo = getPrinter();

            Random random = new Random();
            long millisecond = random.nextInt(10) * 1000;
            Thread.sleep(millisecond);
            System.out.printf("%s: printer-%s print one,spent %d millisecond\n", Thread.currentThread().getName(), printNo, millisecond);

            //释放打印机
            freePrinter(printNo);
            //释放信号量
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取可用打印机
     *
     * @return
     */
    private int getPrinter() {
        int id = -1;
        try {
            printLock.lock();

            for (int i = 0; i < printers.length; i++) {
                if (printers[i]) {
                    id = i;
                    printers[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printLock.unlock();
        }
        return id;
    }

    /**
     * 释放打印机
     *
     * @return
     */
    private void freePrinter(int printNo) {
        try {
            printLock.lock();
            printers[printNo] = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printLock.unlock();
        }
    }


}
