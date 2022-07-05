package multiton;

import java.util.HashMap;

public class FahrzeugtypHelper {
    private static HashMap<String, Fahrzeugtyp> ftyp = new HashMap<>();

    static {
        ftyp.put("Zweirad",Zweirad.getFahrzeugtyp());
        ftyp.put("Trike",Trike.getFahrzeugtyp());
        ftyp.put("Quad",Quad.getFahrzeugtyp());
        ftyp.put("PKW",PKW.getFahrzeugtyp());
        ftyp.put("SUV",SUV.getFahrzeugtyp());
        ftyp.put("Pickup",Pickup.getFahrzeugtyp());
    }

    private FahrzeugtypHelper() {
        //FahrzeugtypHelper is a Utility class
    }

    /**
     * Returns the vehicle type and returns null if it doesn't exist
     * @param st String with vehicle type designation
     * @return Vehicle type object or null
     */
    public static Fahrzeugtyp getCar(String st) {
        return ftyp.get(st);
    }
}
