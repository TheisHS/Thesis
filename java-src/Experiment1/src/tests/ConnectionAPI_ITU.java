package tests;

import task.ConnectionAPI;

public class ConnectionAPI_ITU extends ConnectionAPI {
  @Override
  public boolean isITUPlusPlusAvailable() {
    return true;
  }
  @Override
  public boolean isEduroamAvailable() {
    return false;
  }
}