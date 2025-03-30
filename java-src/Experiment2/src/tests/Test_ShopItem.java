package tests;

import task.*;

public class Test_ShopItem extends Test {
  public int test1() {
    StockAPI.API = new StockAPI_AB();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    return i1.inStock() && i2.inStock() ? 1 : 0;
  }

  public int test2() {
    int price = 10;
    ShopItem i1 = new ShopItem(123, price);

    return i1.price == price ? 1 : 0;
  }

  public int test3() {
    StockAPI.API = new StockAPI_None();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    return i1.inStock() || i2.inStock() ? 0 : 1;
  }

  public int test4() {
    StockAPI.API = new StockAPI_A();

    ShopItem i1 = new ShopItem(123, 10);
    ShopItem i2 = new ShopItem(246, 10);

    return i1.inStock() && !i2.inStock() ? 1 : 0;
  }
}
