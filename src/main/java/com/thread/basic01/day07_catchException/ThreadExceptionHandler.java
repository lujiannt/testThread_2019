package com.thread.basic01.day07_catchException;

public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("an Exceotion happen \n");
        System.out.printf("Thread:%s\n  ExceptionClass:%s\n  ExceptionMsg:%s\n",
                Thread.currentThread().getName(), e.getClass(), e.getMessage());
    }
}
