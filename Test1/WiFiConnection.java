package Test1;

import java.util.Random;

public class WiFiConnection implements Connection{
  @Override
  public boolean connect() {
    return new Random().nextBoolean();
  }
}
