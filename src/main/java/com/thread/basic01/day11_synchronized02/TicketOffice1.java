package com.thread.basic01.day11_synchronized02;

public class TicketOffice1 implements Runnable {
    private Cenima cenima;

    public TicketOffice1(Cenima cenima) {
        this.cenima = cenima;
    }

    @Override
    public void run() {
        cenima.sellTicket1(5);
        cenima.sellTicket2(6);

        cenima.returnTicket1(1);
        cenima.returnTicket2(1);
    }
}
