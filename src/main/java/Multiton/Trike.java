package Multiton;

public class Trike extends Fahrzeugtyp {
    private static Fahrzeugtyp instance = new Trike();
    private Trike() {
        super(2, 0.7);
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
