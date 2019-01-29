package com.thread.basic01.day11_synchronized02;

public class Cenima {
    private int movie1_num;
    private int movie2_num;
    public Object movie1Control, movie2Control;

    public Cenima(int movie1_num, int movie2_num) {
        this.movie1_num = movie1_num;
        this.movie2_num = movie2_num;
        movie1Control = new Object();
        movie2Control = new Object();
    }

    public int getMovie1_num() {
        return movie1_num;
    }

    public void setMovie1_num(int movie1_num) {
        this.movie1_num = movie1_num;
    }

    public int getMovie2_num() {
        return movie2_num;
    }

    public void setMovie2_num(int movie2_num) {
        this.movie2_num = movie2_num;
    }

    public Object getMovie1Control() {
        return movie1Control;
    }

    public void setMovie1Control(Object movie1Control) {
        this.movie1Control = movie1Control;
    }

    public Object getMovie2Control() {
        return movie2Control;
    }

    public void setMovie2Control(Object movie2Control) {
        this.movie2Control = movie2Control;
    }

    public void sellTicket1(int number) {
        synchronized (movie1Control) {
            if (number <= movie1_num) {
                movie1_num -= number;
                System.out.printf("%s：卖了%d张电影1的票\n", Thread.currentThread().getName(), number);
            }
        }
    }

    public void returnTicket1(int number) {
        synchronized (movie1Control) {
            movie1_num += number;
            System.out.printf("%s：退了%d张电影1的票\n", Thread.currentThread().getName(), number);
        }
    }

    public void sellTicket2(int number) {
        synchronized (movie2Control) {
            if (number <= movie2_num) {
                movie2_num -= number;
                System.out.printf("%s：卖了%d张电影2的票\n", Thread.currentThread().getName(), number);
            }
        }

    }

    public void returnTicket2(int number) {
        synchronized (movie2Control) {
            movie2_num += number;
            System.out.printf("%s：退了%d张电影2的票\n", Thread.currentThread().getName(), number);
        }
    }
}
