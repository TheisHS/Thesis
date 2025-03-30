package tests;

import task.DeviceAPI;
import java.util.*;

public class DeviceAPI_Wifi extends DeviceAPI {
  @Override
  public ArrayList<String> getAvailableConnections() {
    ArrayList<String> connections = new ArrayList<>();

    connections.add("wifi");

    return connections;
  }
}