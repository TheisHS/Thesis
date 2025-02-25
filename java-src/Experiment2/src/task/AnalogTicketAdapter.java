package task;

public class AnalogTicketAdapter extends ScrollBarVoucher {
  AnalogTicket analogTicket;

  public AnalogTicketAdapter(AnalogTicket analogTicket) {
    super(analogTicket.getCoffeesLeft() * 8);
    this.analogTicket = analogTicket;
  }
}
