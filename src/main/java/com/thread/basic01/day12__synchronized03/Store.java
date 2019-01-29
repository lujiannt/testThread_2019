package com.thread.basic01.day12__synchronized03;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

public class Store {
    private int maxSize = 10;
    private Deque<Product> deque = new ArrayDeque<>();

    public void product() {
        synchronized (deque) {
            if (deque.size() < maxSize) {
                Product product = new Product(UUID.randomUUID().toString());
                deque.addFirst(product);
                System.out.printf("%s:生产了product, 剩余长度为%d\n", Thread.currentThread().getName(), deque.size());
            } else {
                System.out.println("11111");
            }
        }

    }

    public void consume() {
        synchronized (deque) {
            if (deque.size() > 0) {
                deque.removeFirst();
                System.out.printf("%s:消费了product, 剩余长度为%d\n", Thread.currentThread().getName(), deque.size());
            } else {
                System.out.println("22222");
            }
        }
    }
}
