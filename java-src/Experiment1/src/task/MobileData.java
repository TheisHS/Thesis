package task;

public class MobileData implements WifiConnection {
  public boolean connect() {
    return ConnectionAPI.API.isMobileDataAvailable();
  }
}
