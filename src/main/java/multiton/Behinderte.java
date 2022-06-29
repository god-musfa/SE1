package multiton;

public class Behinderte extends Kundentyp{
    private static Kundentyp instance = new Behinderte();
    private Behinderte() {
        super(6);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
