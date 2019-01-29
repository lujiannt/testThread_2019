package com.thread.basic01.day12__synchronized03;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Thread product = new Thread(new Producer(store), "生产者");
        Thread consume1 = new Thread(new Consumer(store), "消费者1");
        Thread consume2 = new Thread(new Consumer(store), "消费者2");

        try {
            product.start();
            Thread.sleep(1000);

            consume1.start();
            consume2.start();

            product.join();
            consume1.join();
            consume2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("模拟结束");
    }
}
