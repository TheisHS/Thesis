package tests;

import task.ConnectionAPI;

public class ConnectionAPI_Both extends ConnectionAPI {
  @Override
  public boolean isITUPlusPlusAvailable() {
    return true;
  }
  @Override
  public boolean isEduroamAvailable() {
    return true;
  }
}