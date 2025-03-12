package tests;

import task.DeviceAPI;
import java.util.*;

public class DeviceAPI_ITU extends DeviceAPI {
  @Override
  public ArrayList<String> getAvailableConnections() {
    ArrayList<String> connections = new ArrayList<>();

    connections.add("ituplusplus");

    return connections;
  }
}