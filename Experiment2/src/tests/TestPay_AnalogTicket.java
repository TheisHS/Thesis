package tests;

import task.*;

public class TestPay_AnalogTicket extends Test {
  public int test1() {
    ScrollBar sb = new ScrollBar();
    AnalogTicket ticket = new AnalogTicket(7);

    return sb.pay("Carrot Juice", new AnalogTicketAdapter(ticket)) ? 1 : 0;
  }

  public int test2() {
    ScrollBar sb = new ScrollBar();
    AnalogTicket ticket = new AnalogTicket(3);

    return !sb.pay("Tuborg", new AnalogTicketAdapter(ticket)) ? 1 : 0;
  }

  public int test3() {
    ScrollBar sb = new ScrollBar();
    AnalogTicket ticket = new AnalogTicket(4);

    return sb.pay("Cola", new AnalogTicketAdapter(ticket)) ? 1 : 0;
  }

  public int test4() {
    ScrollBar sb = new ScrollBar();
    AnalogTicket ticket = new AnalogTicket(4);

    return !sb.pay("Tequila Shots", new AnalogTicketAdapter(ticket)) ? 1 : 0;
  }
}
