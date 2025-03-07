package tests;

import task.*;

public class TestPay_ScrollBarVoucher extends Test {
  public int test1() {
    ScrollBar sb = new ScrollBar();
    ScrollBarVoucher voucher = new ScrollBarVoucher(30);

    return sb.pay("Tuborg", voucher) ? 1 : 0;
  }

  public int test2() {
    ScrollBar sb = new ScrollBar();
    ScrollBarVoucher voucher = new ScrollBarVoucher(20);

    return !sb.pay("ScrollBar Punch", voucher) ? 1 : 0;
  }

  public int test3() {
    ScrollBar sb = new ScrollBar();
    ScrollBarVoucher voucher = new ScrollBarVoucher(30);

    return sb.pay("Water", voucher) ? 1 : 0;
  }

  public int test4() {
    ScrollBar sb = new ScrollBar();
    ScrollBarVoucher voucher = new ScrollBarVoucher(20);

    return !sb.pay("Carrot Juice", voucher) ? 1 : 0;
  }
}
