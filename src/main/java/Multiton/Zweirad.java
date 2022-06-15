package Multiton;

public class Zweirad extends Fahrzeugtyp {
    private static Fahrzeugtyp instance = new Zweirad();
    private Zweirad() {
        super(1, 0.5);
    }

    public static Fahrzeugtyp getFahrzeugtyp() {
        return instance;
    }
}
