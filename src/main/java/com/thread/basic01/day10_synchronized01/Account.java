package com.thread.basic01.day10_synchronized01;

public class Account {
    private int amount;


    public Account(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //去掉synchronized会导致账户余额为负数
    public synchronized void modify(int amount) {
        boolean flag = true;
        if (amount >= 0) {
            System.out.printf("%s：向账户存款%d元\n", Thread.currentThread().getName(), amount);
        } else if (amount < 0 && -amount <= this.amount) {
            System.out.printf("%s：向账户取款%d元\n", Thread.currentThread().getName(), -amount);
        } else {
            flag = false;
            System.out.printf("%s：向账户取款%d元，余额不足\n", Thread.currentThread().getName(), -amount);
        }

        if (flag) {
            this.amount += amount;
        }
    }
}
