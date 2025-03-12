public class ITUPlusPlus implements WifiConnection {
    public Boolean connect(){
        return ConnectionAPI.API.isITUPlusPlusAvailable();
    }
}
