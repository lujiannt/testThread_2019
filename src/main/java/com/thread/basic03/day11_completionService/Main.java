package com.thread.basic03.day11_completionService;

import java.util.concurrent.*;

/**
 * 执行线程和处理结果线程使用两线程分离开,completionService
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //核心completionService
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        //创建两个请求报告的线程
        ReportRequest reportRequest1 = new ReportRequest("report1", completionService);
        ReportRequest reportRequest2 = new ReportRequest("report2", completionService);
        //创建一个处理结果的线程
        ResultProcessor resultProcessor = new ResultProcessor(false, completionService);

        //创建两个请求报告的线程
        Thread threadRequest1 = new Thread(reportRequest1);
        Thread threadRequest2 = new Thread(reportRequest2);
        //创建一个处理结果的线程
        Thread threadResult = new Thread(resultProcessor);

        threadRequest1.start();
        threadRequest2.start();
        threadResult.start();

        try {
            threadRequest1.join();
            threadRequest2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultProcessor.setEnd(true);
    }
}
