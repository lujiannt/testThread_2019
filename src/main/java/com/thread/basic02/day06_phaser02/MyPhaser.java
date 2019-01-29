package com.thread.basic02.day06_phaser02;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("当前阶段" + phase + ",当前参与人数" + registeredParties);
        switch (phase) {
            case 0:
                //第一阶段，等待学生到齐
                return studentArrived();
            case 1:
                //第二阶段，完成第一场考试
                return finishFirstExam();
            case 2:
                //第三阶段，完成第二场考试
                return finishSecondExam();
            case 3:
                //第四阶段，完成考试
                return finishExam();
        }

        return super.onAdvance(phase, registeredParties);
    }


    /**
     * 学生到达
     *
     * @return
     */
    public boolean studentArrived() {
        System.out.println("all student arrived");
        return false;
    }

    /**
     * 学生完成第一场考试
     *
     * @return
     */
    public boolean finishFirstExam() {
        System.out.println("all student finish first exam");
        return false;
    }

    /**
     * 学生完成第二场考试
     *
     * @return
     */
    public boolean finishSecondExam() {
        System.out.println("all student finish second exam");
        return false;
    }

    /**
     * 学生完成第三场考试
     *
     * @return
     */
    public boolean finishExam() {
        System.out.println("all student finish all exams");
        return true;
    }

}
