package Experiment1.src;

import java.util.*;


public class API {
  
  public static ArrayList<String> getAvailableConnections() {
    Random random = new Random();
    ArrayList<String> connections = new ArrayList<>();

    if (random.nextInt(100) < 80) {
      connections.add("bluetooth");
    }

    connections.add("wifi");

    return connections;
  }
}
