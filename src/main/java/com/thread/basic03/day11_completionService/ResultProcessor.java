package com.thread.basic03.day11_completionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 结果处理
 */
public class ResultProcessor implements Runnable {
    private boolean end;
    private CompletionService<String> completionService;

    public ResultProcessor(boolean end, CompletionService<String> completionService) {
        this.end = end;
        this.completionService = completionService;
    }

    @Override
    public void run() {
        try {
            while (!end) {
                //使用completionService从队列中获取执行完的结果；如果为null则等待20s，如果还未null则返回null
                Future<String> future = completionService.poll(20, TimeUnit.SECONDS);
                if (future != null) {
                    System.out.printf("received %s\n", future.get());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
