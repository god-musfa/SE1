package Multiton;

public class Pickup extends Fahrzeugtyp {
    private static Fahrzeugtyp instance = new Pickup();
    private Pickup() {
        super(6, 1.5);
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
