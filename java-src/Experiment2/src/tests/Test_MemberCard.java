package tests;

import task.*;

public class Test_MemberCard extends Test {
  private final int balance = 1000; 
  
  public int test1() {
    MemberCard c = new MemberCard();
    
    return c.hasFunds(balance) ? 0 : 1;
  } 
  
  public int test2() {
    MemberCard c = new MemberCard();
    
    c.addToBalance(balance);
    return c.hasFunds(balance) ? 1 : 0;
  } 

  public int test3() {
    MemberCard c = new MemberCard();
    
    c.addToBalance(balance);

    try {
      c.spend(balance);
      return c.balance == 0 ? 1 : 0;
    } catch (Exception e) {
      return 0;
    }
  } 

  public int test4() {
    MemberCard c = new MemberCard();

    c.addToBalance(balance);

    try {
      c.spend(balance + 1);
      return 0;
    } catch (Exception e) {
      return c.balance == balance ? 1 : 0;
    }
  } 
}
