package task;

import java.util.*;

public class Device {
  public WifiConnection connection;

  public void connect() {
    ArrayList<String> available = DeviceAPI.API.getAvailableConnections();
    if (available.contains("ituplusplus")) {
      connection = new ITUPlusPlus();
      boolean success = connection.connect();
      if (success) return;
    } 
    if (available.contains("eduroam")) {
      connection = new Eduroam();
      boolean success = connection.connect();
      if (success) return;
    } 
    
    throw new RuntimeException("No suitable connection found");
  }
}
