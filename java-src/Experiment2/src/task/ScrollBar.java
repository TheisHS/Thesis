package task;

public class ScrollBar {
  public int getPrice(String item) {
    return ScrollBarMenu.menucard.get(item);
  }

  public boolean pay(String name, ScrollBarVoucher voucher) {
    return voucher.getWorth() >= getPrice(name);
  }
}
