package multiton;

public class Frau extends Kundentyp{
    private static Kundentyp instance = new Frau();
    private Frau() {
        super(6);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
