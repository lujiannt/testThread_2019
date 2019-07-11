package com.thread.basic03.day14_schedule;

public class Test1 {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();

        u2.say("2");
        u1.say("1");

//        Thread t1= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                u1.say("u1");
//            }
//        });
//
//        Thread t2= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                u1.say("u2");
//            }
//        });
//
//
//        t1.start();
//        t2.start();

    }
}
