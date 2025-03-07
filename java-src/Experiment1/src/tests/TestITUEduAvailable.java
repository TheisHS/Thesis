package tests;

import task.*;

public class TestITUEduAvailable extends Test {
  // both connectable, ITU given first
  // should be ITU++
  public int test1() {
    DeviceAPI.API = new DeviceAPI_ITUEdu();
    ConnectionAPI.API = new ConnectionAPI_Both();

    Device d = new Device();
    d.connect();
    return d.connection instanceof ITUPlusPlus ? 1 : 0;
  }

  // Eduroam connectable, ITU given first
  // should be Eduroam
  public int test2() {
    DeviceAPI.API = new DeviceAPI_ITUEdu();
    ConnectionAPI.API = new ConnectionAPI_Eduroam();

    Device d = new Device();
    d.connect();
    return d.connection instanceof Eduroam ? 1 : 0;
  }

  // ITU connectable, ITU given first
  // should be ITU++
  public int test3() {
    DeviceAPI.API = new DeviceAPI_ITUEdu();
    ConnectionAPI.API = new ConnectionAPI_ITU();

    Device d = new Device();
    d.connect();
    return d.connection instanceof ITUPlusPlus ? 1 : 0;
  }

  // None connectable, ITU given first
  // should throw exception
  public int test4() {
    DeviceAPI.API = new DeviceAPI_ITUEdu();
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
