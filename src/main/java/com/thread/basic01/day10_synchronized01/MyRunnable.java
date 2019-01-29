package com.thread.basic01.day10_synchronized01;

public class MyRunnable implements Runnable {
    private int amount;
    private Account account;

    public MyRunnable(int amount, Account account) {
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void run() {
        account.modify(amount);
    }
}
