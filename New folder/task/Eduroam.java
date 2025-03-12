public class Eduroam implements WifiConnection{
    public Boolean connect(){
        return ConnectionAPI.API.isEduroamAvailable();
    }
}
