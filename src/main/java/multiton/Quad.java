package multiton;

public class Quad extends Fahrzeugtyp {
    private static Fahrzeugtyp instance = new Quad();
    private Quad() {
        super(3, 0.8);
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
