package multiton;

public class Firmenkunde extends Kundentyp{
    private static Kundentyp instance = new Firmenkunde();
    private Firmenkunde() {

        super(0.05);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
