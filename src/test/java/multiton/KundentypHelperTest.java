package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"0.075,Frau", "0,Abonnent", "0.05,Behinderte", "0.05,Firmenkunde", "0.075,Familie", "0.1,Parkhauskunde"})
    @DisplayName("Checks the getGebuehrenfak method for Customertype")
    void getGebuehrenfakTest(double d, String s) {
        assertEquals(d, KundentypHelper.getKunde(s).getGebuehrenfak());
    }

}
