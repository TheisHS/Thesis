package tests;

public abstract class Test {
  private static int TOTAL_TESTS = 10;

  public static void testAll() {
    int success = 0;
    success += new TestPay_AnalogTicket().test();
    success += new TestPay_ScrollBarVoucher().test();
    success += new Test_AnalogTicketAdapter().test();
    System.out.println(String.format("%d/%d tests passed", success, TOTAL_TESTS));
  }

  public int test() {
    return test1() + test2() + test3() + test4();
  }
  public abstract int test1();
  public abstract int test2();
  public abstract int test3();
  public abstract int test4();
}
