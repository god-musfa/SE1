package multiton;

public class Parkhauskunde extends Kundentyp{
    private static Kundentyp instance = new Parkhauskunde();
    private Parkhauskunde() {
        super(0.1);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
