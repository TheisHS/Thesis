package tests;

import task.*;

public class TestWifiAvailable extends Test  {
  // both connectable
  // should be Wifi
  public int test1() {
    DeviceAPI.API = new DeviceAPI_Wifi();
    ConnectionAPI.API = new ConnectionAPI_Both();

    Device d = new Device();
    d.connect();
    return d.connection instanceof Wifi ? 1 : 0;
  }

  // MobileData connectable
  // should throw exception
  public int test2() {
    DeviceAPI.API = new DeviceAPI_Wifi();
    ConnectionAPI.API = new ConnectionAPI_MobileData();
    
    Device d = new Device();
    try {
      d.connect();
    } catch (Exception e) {
      return 1;
    }
    return 0;
  }

  // Wifi connectable
  // should be Wifi
  public int test3() {
    DeviceAPI.API = new DeviceAPI_Wifi();
    ConnectionAPI.API = new ConnectionAPI_Wifi();

    Device d = new Device();
    d.connect();
    return d.connection instanceof Wifi ? 1 : 0;
  }

  // None connectable
  // should throw exception
  public int test4() {
    DeviceAPI.API = new DeviceAPI_Wifi();
    ConnectionAPI.API = new ConnectionAPI_None();

    Device d = new Device();
    try {
      d.connect();
    } catch (Exception e) {
      return 1;
    }
    return 0;
  }
}
