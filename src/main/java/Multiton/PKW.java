package Multiton;

public class PKW extends Fahrzeugtyp {
    private static Fahrzeugtyp instance = new PKW();

    private PKW() {
        super(4, 1);
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
