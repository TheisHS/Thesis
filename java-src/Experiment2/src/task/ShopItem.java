package task;

public class ShopItem {
  public int id;
  public int price;

  public ShopItem(int id, int price) {
    this.id = id;
    this.price = price;
  }

  public boolean inStock() {
    int[] inStock = StockAPI.API.getStockIds();
    for (int i = 0; i < inStock.length; i++) {
      if (inStock[i] == id) {
        return true;
      }
    }
    return false;
  }
}
