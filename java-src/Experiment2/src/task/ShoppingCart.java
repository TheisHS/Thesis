package task;

import java.util.ArrayList;

public class ShoppingCart {
  public ArrayList<ShopItem> items;

  public ShoppingCart() {
    items = new ArrayList<ShopItem>();
  }
  
  public void addToCart(ShopItem item) {
    if (item.inStock()) {
      items.add(item);
    } else {
      throw new RuntimeException("Item is out of stock.");
    }
  }

  public void buy(PaymentMethod method) {
    int totalCost = 0;
    for (ShopItem item : items) {
      if (!item.inStock()) {
        throw new RuntimeException("Item is out of stock.");
      }
      totalCost += item.price;
    }
    if (method.hasFunds(totalCost)) {
      method.spend(totalCost);
      items.clear();
    } else {
      throw new RuntimeException("Insufficient funds.");
    }
  }
}
