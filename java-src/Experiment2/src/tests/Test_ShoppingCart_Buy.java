package tests;

import task.*;

public class Test_ShoppingCart_Buy extends Test {
  public int test1() {
    StockAPI.API = new StockAPI_AB();

    CreditCard c = new CreditCard();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      cart.buy(c);

      return 1;
    } catch (Exception e) {
      return 0;
    }
  }

  public int test2() {
    StockAPI.API = new StockAPI_AB();

    MemberCard c = new MemberCard();
    int balance = 1000;
    c.addToBalance(balance);

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      cart.buy(c);

      return c.balance == balance - (i1.price + i2.price) ? 1 : 0;
    } catch (Exception e) {
      return 0;
    }
  }

  public int test3() {
    StockAPI.API = new StockAPI_AB();

    MemberCard c = new MemberCard();
    int balance = 10;
    c.addToBalance(balance);

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      cart.buy(c);

      return 0;
    } catch (Exception e) {
      return c.balance == balance ? 1 : 0;
    }
  }

  public int test4() {
    return 0; // No test for this case
  }
}
