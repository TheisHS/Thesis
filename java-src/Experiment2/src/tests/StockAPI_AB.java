package tests;

import task.StockAPI;

public class StockAPI_AB extends StockAPI {
  @Override
  public int[] getStockIds() {
    return new int[] { 123, 246 };
  }
}
