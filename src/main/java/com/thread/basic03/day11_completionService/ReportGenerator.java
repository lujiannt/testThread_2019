package com.thread.basic03.day11_completionService;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 报告生成
 */
public class ReportGenerator implements Callable<String> {
    private String title;

    public ReportGenerator(String title) {
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        Random random = new Random();
        int sleepSecond = random.nextInt(10);
        TimeUnit.SECONDS.sleep(sleepSecond);
        System.out.printf("%s生成report中...\n", Thread.currentThread().getName());
        return "report-" + title;
    }
}
