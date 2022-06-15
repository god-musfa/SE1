package Multiton;

public class Zweirad extends Fahrzeugtyp {
    private static Fahrzeugtyp instance;
    private Zweirad() {
        super(1);
        instance =  new Zweirad();
    }

    public Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
