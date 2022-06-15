package Multiton;

import java.util.HashMap;

public class FahrzeugtypHelper {
    private static HashMap<String, Fahrzeugtyp> ftyp = new HashMap<>(){
        {
            put("Zweirad",Zweirad.getFahrzeugtyp());
            put("Trike",Trike.getFahrzeugtyp());
            put("Quad",Quad.getFahrzeugtyp());
            put("PKW",PKW.getFahrzeugtyp());
            put("SUV",SUV.getFahrzeugtyp());
            put("Pickup",Pickup.getFahrzeugtyp());
        }
    };

    public static Fahrzeugtyp getFahrzeug(String st) {
        return ftyp.get(st);
    }
}
