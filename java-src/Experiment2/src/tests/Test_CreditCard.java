package tests;

import task.*;

public class Test_CreditCard extends Test {
  private final int balance = 1000; 

  public int test1() {
    CreditCard c = new CreditCard();
    
    return c.hasFunds(balance) ? 1 : 0;
  }
  
  public int test2() {
    CreditCard c = new CreditCard();

    try {
      c.spend(balance);
      return 1;
    } catch (Exception e) {
      return 0;
    }
  } 
  
  public int test3() {
    return 0; // No test for this case
  } 

  public int test4() {
    return 0; // No test for this case
  }
}
