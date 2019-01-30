package com.thread.basic02.day07_exchanger;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("当前阶段" + phase + ",当前参与人数" + registeredParties);
        switch (phase) {
            case 0:
                //第一阶段，等待交换数据
                return dealData();
            case 1:
                //第二阶段，等待交换数据
                return exchangeData();
            case 2:
                //第三阶段，完成第一场考试
                return finishTask();
        }

        return super.onAdvance(phase, registeredParties);
    }

    /**
     * 第一阶段-生产者生成；消费者消费
     *
     * @return
     */
    public boolean dealData() {
        System.out.println("is going to dealData Data....");
        return false;
    }

    /**
     * 开始交换数据
     *
     * @return
     */
    public boolean exchangeData() {
        System.out.println("is going to exchange Data....");
        return false;
    }

    /**
     * 任务完成
     *
     * @return
     */
    public boolean finishTask() {
        System.out.println("finish Task....");
        return true;
    }
}
