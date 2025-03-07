package tests;

import task.DeviceAPI;
import java.util.*;

public class DeviceAPI_EduITU extends DeviceAPI {
  @Override
  public ArrayList<String> getAvailableConnections() {
    ArrayList<String> connections = new ArrayList<>();

    connections.add("eduroam");
    connections.add("ituplusplus");

    return connections;
  }
}