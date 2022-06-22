package multiton;

public class SUV extends Fahrzeugtyp {
    private static Fahrzeugtyp instance =  new SUV();

    private SUV() {
        super(5, 1.3);
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
