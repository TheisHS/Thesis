package tests;

import task.ConnectionAPI;

public class ConnectionAPI_None extends ConnectionAPI {
  @Override
  public boolean isITUPlusPlusAvailable() {
    return false;
  }
  @Override
  public boolean isEduroamAvailable() {
    return false;
  }
}