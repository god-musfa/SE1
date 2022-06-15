package Multiton;

public class SUV extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;

    private SUV() {
        super(5);
        instance =  new SUV();
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
