package tests;

import task.ConnectionAPI;

public class ConnectionAPI_MobileData extends ConnectionAPI {
  @Override
  public boolean isWifiAvailable() {
    return false;
  }
  @Override
  public boolean isMobileDataAvailable() {
    return true;
  }
}