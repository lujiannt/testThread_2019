package com.thread.basic03.day12_rejectedExecution;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 执行器拒绝任务 处理器
 */
public class RejectHandlerController implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectController: task %s has been rejected\n", r.toString());
        System.out.printf("RejectController: executor is %s\n", executor.toString());
        System.out.printf("RejectController: executor terminating: %s\n", executor.isTerminating());
        System.out.printf("RejectController: executor terminated: %s\n", executor.isTerminated());
    }
}
