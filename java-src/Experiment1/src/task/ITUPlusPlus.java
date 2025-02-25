package task;

public class ITUPlusPlus implements WifiConnection {
  public boolean connect() {
    return ConnectionAPI.API.isITUPlusPlusAvailable();
  }
}
