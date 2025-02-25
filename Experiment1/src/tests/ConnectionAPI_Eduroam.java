package tests;

import task.ConnectionAPI;

public class ConnectionAPI_Eduroam extends ConnectionAPI {
  @Override
  public boolean isITUPlusPlusAvailable() {
    return false;
  }
  @Override
  public boolean isEduroamAvailable() {
    return true;
  }
}