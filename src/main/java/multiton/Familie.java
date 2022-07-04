package multiton;

public class Familie extends Kundentyp{
    private static Kundentyp instance = new Familie();
    private Familie() {
        super(0.075);
    }

    public static Kundentyp getKundentyp() {
        return instance;
    }
}
