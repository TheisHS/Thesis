package tests;

import task.*;

public class Test_AnalogTicketAdapter extends Test {
  public int test1() {
    int coffeesLeft = 4;
    var ticket = new AnalogTicket(coffeesLeft);
    var adapter = new AnalogTicketAdapter(ticket);

    return adapter.getWorth() == coffeesLeft*8 ? 1 : 0;
  }

  public int test2() {
    int coffeesLeft = 1;
    var ticket = new AnalogTicket(coffeesLeft);
    var adapter = new AnalogTicketAdapter(ticket);

    return adapter.getWorth() == coffeesLeft*8 ? 1 : 0;
  }

  public int test3() {
    return 0;
  }

  public int test4() {
    return 0;
  }
}
