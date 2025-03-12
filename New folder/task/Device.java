import java.util.ArrayList;

public class Device {
    private WifiConnection connection;

    public Device(){
        connection = null;
    }

    public void connect() throws Exception{
        ArrayList<String> connects = DeviceAPI.API.getAvailableConnections();
        if (connects.contains("ITUPlusPlus")){
            ITUPlusPlus itu = new ITUPlusPlus();
            if (itu.connect()) connection = itu;
        } else if (connects.contains("Eduroam")){
            Eduroam edu = new Eduroam();
            if (edu.connect()) connection = edu;
        } else throw new Exception("shit aint working");
    }
}
