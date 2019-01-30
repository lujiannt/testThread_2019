package com.thread.basic03.day02_poolSize;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            server.executeTask(task);
        }

        server.shutDown();
    }
}
