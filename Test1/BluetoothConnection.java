package Test1;

import java.util.*;

public class BluetoothConnection implements Connection {
  @Override
  public boolean connect() {
    return new Random().nextBoolean();
  }
  
}
