package Multiton;

public class Pickup extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;
    private Pickup() {
        super(6);
        instance =  new Pickup();
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
