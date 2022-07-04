package multiton;

public class Behinderte extends Kundentyp{
    private static Kundentyp instance = new Behinderte();
    private Behinderte() {
        super(0.05);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
