package tests;

import task.ConnectionAPI;

public class ConnectionAPI_Wifi extends ConnectionAPI {
  @Override
  public boolean isWifiAvailable() {
    return true;
  }
  @Override
  public boolean isMobileDataAvailable() {
    return false;
  }
}