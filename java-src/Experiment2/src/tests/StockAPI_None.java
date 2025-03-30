package tests;

import task.StockAPI;

public class StockAPI_None extends StockAPI {
  @Override
  public int[] getStockIds() {
    return new int[] {};
  }
}
