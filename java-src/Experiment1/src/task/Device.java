package task;

import java.util.*;

public class Device {
  public WifiConnection connection;

  public void connect() {
    ArrayList<String> available = DeviceAPI.API.getAvailableConnections();
    if (available.contains("wifi")) {
      connection = new Wifi();
      boolean success = connection.connect();
      if (success) return;
    } 
    if (available.contains("mobiledata")) {
      connection = new MobileData();
      boolean success = connection.connect();
      if (success) return;
    } 
    
    throw new RuntimeException("No suitable connection found");
  }
}
