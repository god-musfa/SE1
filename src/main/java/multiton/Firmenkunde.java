package multiton;

public class Firmenkunde extends Kundentyp{
    private static Kundentyp instance = new Firmenkunde();
    private Firmenkunde() {

        super(6);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
