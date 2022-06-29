package multiton;
import java.util.HashMap;

public class KundentypHelper {
    private static HashMap<String, Kundentyp> ktyp = new HashMap<>();

    static {
        ktyp.put("Abonnent",Abonnent.getKundentyp());
        ktyp.put("Behinderte",Behinderte.getKundentyp());
        ktyp.put("Familie",Familie.getKundentyp());
        ktyp.put("Firmenkunde",Firmenkunde.getKundentyp());
        ktyp.put("Frau",Frau.getKundentyp());
        ktyp.put("Parkhauskunde",Parkhauskunde.getKundentyp());
    }

    private KundentypHelper() {
        throw new IllegalStateException("KundentypHelper is a Utitlity class");
    }


    public static Kundentyp getKunde(String kt) {

        return ktyp.get(kt);
    }
}
