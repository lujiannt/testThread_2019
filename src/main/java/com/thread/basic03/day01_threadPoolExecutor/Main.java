package com.thread.basic03.day01_threadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        Task task = new Task();

        server.executeTask(task);
    }
}
