package com.thread.basic01.day11_synchronized02;

public class TicketOffice2 implements Runnable {
    private Cenima cenima;

    public TicketOffice2(Cenima cenima) {
        this.cenima = cenima;
    }

    @Override
    public void run() {
        cenima.sellTicket1(5);
        cenima.sellTicket1(4);
        cenima.returnTicket1(1);

        cenima.sellTicket2(7);
        cenima.returnTicket2(2);
    }
}
