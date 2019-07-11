package com.thread.basic03.day14_schedule;

public class User {
    public void say(String name) {
        try {
            System.out.println(name + " start say....");
            Thread.sleep(5000);
            System.out.println(name + " end say");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
