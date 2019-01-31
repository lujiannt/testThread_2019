package com.thread.basic03.day11_completionService;

import java.util.concurrent.CompletionService;

/**
 * 请求报告
 */
public class ReportRequest implements Runnable {
    private String name;
    private CompletionService<String> completionService;

    public ReportRequest(String name, CompletionService<String> completionService) {
        this.name = name;
        this.completionService = completionService;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name);
        //使用completionService执行线程
        completionService.submit(reportGenerator);
    }
}
