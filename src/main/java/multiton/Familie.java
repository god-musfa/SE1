package multiton;

public class Familie extends Kundentyp{
    private static Kundentyp instance = new Familie();
    private Familie() {
        super(6);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
