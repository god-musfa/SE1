package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KundentypHelperTest {

    @Test
    @DisplayName("Testet ob die Personengruppe vom erwarteten Typ ist")
    void getPersonengruppe() {
        assertTrue(KundentypHelper.getKunde("Abonnent") instanceof Abonnent);
        assertTrue(KundentypHelper.getKunde("Behinderte") instanceof Behinderte);
        assertTrue(KundentypHelper.getKunde("Familie") instanceof Familie);
        assertTrue(KundentypHelper.getKunde("Firmenkunde") instanceof Firmenkunde);
        assertTrue(KundentypHelper.getKunde("Frau") instanceof Frau);
        assertTrue(KundentypHelper.getKunde("Parkhauskunde") instanceof Parkhauskunde);
    }


    @Test
    @DisplayName("Prueft ob null zurueckgegeben wird, wenn die Personengruppe undefiniert ist")
    void getPersonengruppe_ungueltigesPersonengruppe_fehlermeldung() {
        assertEquals(null, KundentypHelper.getKunde("ABC"));
    }

}
