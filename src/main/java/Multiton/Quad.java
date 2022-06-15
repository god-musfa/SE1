package Multiton;

public class Quad extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;
    private Quad() {
        super(3);
        instance =  new Quad();
    }

    public Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
