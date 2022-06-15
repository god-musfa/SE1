package Multiton;

public class Trike extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;
    private Trike() {
        super(2);
        instance =  new Trike();
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
