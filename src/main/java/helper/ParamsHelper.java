package helper;

public class ParamsHelper {

    private ParamsHelper(){
        //is a utility class
    }

    public static String getNr(String[] params){
        return params[0];
    }
    public static String getTimer(String[] params){
        return params[1];
    }
    public static String getDuration(String[] params){
        return params[2];
    }
    public static String getPrice(String[] params){
        return params[3];
    }
    public static String getHashForTicket(String[] params){
        return params[4];
    }
    public static String getColor(String[] params){
        return params[5];
    }
    public static String getSpace(String[] params){
        return params[6];
    }
    public static String getClientCategory(String[] params){
        return params[7];
    }
    public static String getVehicleType(String[] params){
        return params[8];
    }
    public static String getLicense(String[] params){
        return params[9];
    }
    public static String getBegin(String[] params){
        return params[10];
    }
    public static String getParkhausName(String[] params){
        return params[11];
    }
}
