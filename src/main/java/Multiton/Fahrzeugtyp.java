package Multiton;

import java.util.HashMap;

public abstract class Fahrzeugtyp {
    protected static Fahrzeugtyp instance;
    private int flaeche;

    public Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
