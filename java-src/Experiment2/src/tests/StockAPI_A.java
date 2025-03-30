package tests;

import task.StockAPI;

public class StockAPI_A extends StockAPI {
  @Override
  public int[] getStockIds() {
    return new int[] { 123 };
  }
}
