package tests;

import task.ConnectionAPI;

public class ConnectionAPI_None extends ConnectionAPI {
  @Override
  public boolean isWifiAvailable() {
    return false;
  }
  @Override
  public boolean isMobileDataAvailable() {
    return false;
  }
}