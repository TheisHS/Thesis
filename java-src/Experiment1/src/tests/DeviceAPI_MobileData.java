package tests;

import task.DeviceAPI;
import java.util.*;

public class DeviceAPI_MobileData extends DeviceAPI {
  @Override
  public ArrayList<String> getAvailableConnections() {
    ArrayList<String> connections = new ArrayList<>();

    connections.add("mobiledata");

    return connections;
  }
}