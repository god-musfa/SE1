package Multiton;

public class Pickup extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;
    private Pickup() {
        super(6);
        instance =  new Pickup();
    }

    public Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
