package Test1;

public class Device {
  private Connection connection;

  public Device() throws Exception {
    var connections = API.getAvailableConnections();
    for (var connectionType : connections) {
      if (connectionType.equals("wifi")) {
        connection = new WiFiConnection();
        if (connection.connect()) {
          System.out.println("Connected to wifi");
          return;
        } else {
          System.out.println("Could not connect to wifi");
        }
      }
      else if(connectionType.equals("bluetooth")) {
        connection = new BluetoothConnection();
        if (connection.connect()) {
          System.out.println("Connected to bluetooth");
          return;
        } else {
          throw new Exception("Could not connect to any available connection");
        }
      }
    }
  }
}

