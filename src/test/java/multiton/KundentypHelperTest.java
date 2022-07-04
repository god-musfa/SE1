package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KundentypHelperTest {

    @Test
    @DisplayName("Tests whether the people group is of the expected type")
    void getPersonengruppe() {
        assertTrue(KundentypHelper.getKunde("Abonnent") instanceof Abonnent);
        assertTrue(KundentypHelper.getKunde("Behinderte") instanceof Behinderte);
        assertTrue(KundentypHelper.getKunde("Familie") instanceof Familie);
        assertTrue(KundentypHelper.getKunde("Firmenkunde") instanceof Firmenkunde);
        assertTrue(KundentypHelper.getKunde("Frau") instanceof Frau);
        assertTrue(KundentypHelper.getKunde("Parkhauskunde") instanceof Parkhauskunde);
    }


    @Test
    @DisplayName("Checks whether null is returned if the group of people is undefined")
    void getPersonengruppe2() {
        assertEquals(null, KundentypHelper.getKunde("ABC"));
    }

    @Test
    @DisplayName("Checks the getGebuehrenfak method")
    void getGebuehrenfakTest(){
        assertEquals(0.075,KundentypHelper.getKunde("Frau").getGebuehrenfak());
        assertEquals(0,KundentypHelper.getKunde("Abonnent").getGebuehrenfak());
        assertEquals(0.05,KundentypHelper.getKunde("Behinderte").getGebuehrenfak());
        assertEquals(0.05,KundentypHelper.getKunde("Firmenkunde").getGebuehrenfak());
        assertEquals(0.075,KundentypHelper.getKunde("Familie").getGebuehrenfak());
        assertEquals(0.1,KundentypHelper.getKunde("Parkhauskunde").getGebuehrenfak());
    }

}
