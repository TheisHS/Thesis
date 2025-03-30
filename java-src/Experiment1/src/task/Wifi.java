package task;

public class Wifi implements WifiConnection {
  public boolean connect() {
    return ConnectionAPI.API.isWifiAvailable();
  }
}
