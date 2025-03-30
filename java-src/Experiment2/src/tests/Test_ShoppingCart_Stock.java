package tests;

import task.*;

public class Test_ShoppingCart_Stock extends Test {
  public int test1() {
    StockAPI.API = new StockAPI_None();

    CreditCard c = new CreditCard();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      cart.buy(c);

      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  public int test2() {
    StockAPI.API = new StockAPI_B();

    CreditCard c = new CreditCard();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      cart.buy(c);

      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  public int test3() {
    StockAPI.API = new StockAPI_AB();

    CreditCard c = new CreditCard();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      
      StockAPI.API = new StockAPI_A();
      cart.buy(c);

      return 0;
    } catch (Exception e) {
      return 1;
    }
  } 

  public int test4() {
    StockAPI.API = new StockAPI_AB();

    CreditCard c = new CreditCard();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    try {
      ShoppingCart cart = new ShoppingCart();
      cart.addToCart(i1);
      cart.addToCart(i2);
      
      StockAPI.API = new StockAPI_None();
      cart.buy(c);

      return 0;
    } catch (Exception e) {
      return 1;
    }
  } 
}
