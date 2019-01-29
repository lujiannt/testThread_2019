package com.thread.basic01.day07_catchException;

/**
 * 捕获线程异常测试
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "Thread-1");
        //设置线程异常处理器
        thread.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        thread.start();
    }
}
