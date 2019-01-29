package com.thread.basic01.day02_attribute;

import org.junit.Test;

/**
 * 线程属性测试类
 */
public class TestThread02_attribute {

    @Test
    public void test1() {
        Thread[] threads = new Thread[10];

        //设置i为双数的线程优先级为最高，单数的为最低
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Calculator(i));
            if (i % 2 == 0) {
                thread.setPriority(Thread.MAX_PRIORITY);
            } else {
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            //设置线程名
            thread.setName("Thread" + i);
            threads[i] = thread;
        }

        //存储所有线程的状态到数组oldStates中
        Thread.State[] oldStates = new Thread.State[10];
        for (int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            oldStates[i] = thread.getState();
        }

        //启动线程
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        //将状态发生改变的线程列出来
        boolean finish = false;
        while (!finish) {
            for (int i = 0; i < threads.length; i++) {
                //判断状态是否改变
                if (threads[i].getState() != oldStates[i]) {
                    if (i == 0) {
                        System.out.println("----------------------");
                    }
                    System.out.println("id : " + threads[i].getId());
                    System.out.println("name : " + threads[i].getName());
                    System.out.println("priority : " + threads[i].getPriority());
                    System.out.println("oldState : " + oldStates[i]);
                    System.out.println("newState : " + threads[i].getState());
                    System.out.println("----------------------");
                }

                finish = true;

                //确认所有线程都执行完毕
                for (int j = 0; j < 10; j++) {
                    finish = finish && threads[j].getState() == Thread.State.TERMINATED;
                }
            }
        }


    }

}
