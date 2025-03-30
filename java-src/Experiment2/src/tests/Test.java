package tests;

public abstract class Test {
  private static int TOTAL_TESTS = 17;

  public static void testAll() {
    int success = 0;
    success += new Test_MemberCard().test();
    success += new Test_CreditCard().test();
    success += new Test_ShopItem().test();
    success += new Test_ShoppingCart_Buy().test();
    success += new Test_ShoppingCart_Stock().test();
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
