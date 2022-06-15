package Multiton;

public class PKW extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;

    private PKW() {
        super(4);
        instance = new PKW();
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
