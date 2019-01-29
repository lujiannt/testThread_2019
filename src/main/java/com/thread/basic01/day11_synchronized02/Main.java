package com.thread.basic01.day11_synchronized02;


/**
 * synchronized测试
 */
public class Main {
    public static void main(String[] args) {
        Cenima cenima = new Cenima(5, 5);
        Thread office1 = new Thread(new TicketOffice1(cenima), "窗口1");
        Thread office2 = new Thread(new TicketOffice2(cenima), "窗口2");
        Thread office3 = new Thread(new TicketOffice1(cenima), "窗口3");
        Thread office4 = new Thread(new TicketOffice2(cenima), "窗口4");
        office1.start();
        office2.start();
        office3.start();
        office4.start();

        try {
            office1.join();
            office2.join();
            office3.join();
            office4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("电影1余票 ：" + cenima.getMovie1_num());
        System.out.println("电影2余票 ：" + cenima.getMovie2_num());
    }
}
