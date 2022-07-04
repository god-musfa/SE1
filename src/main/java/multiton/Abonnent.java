package multiton;

public class Abonnent extends Kundentyp{
    private static Kundentyp instance = new Abonnent();
    private Abonnent() {

        super(0);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
