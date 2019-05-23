package com.thread.basic03.day14_schedule;

import java.util.concurrent.*;

/**
 * 测试定时线程池
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3秒了哦");
            }
        }, 3, TimeUnit.SECONDS);


        ScheduledFuture<Integer> future = service.schedule(new Callable<Integer>() {
            @Override
            public Integer call() {
                return 1;
            }
        }, 3, TimeUnit.SECONDS);
        try {
            System.out.println("res = " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
