package task;

public class Eduroam implements WifiConnection {
  public boolean connect() {
    return ConnectionAPI.API.isEduroamAvailable();
  }
}
