package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugtypHelperTest {
    static final String ZWEIRAD = "Zweirad";
    static final String TRIKE = "Trike";
    static final String QUAD = "Quad";
    static final String PKW = "PKW";
    static final String SUV = "SUV";
    static final String PICKUP = "Pickup";

    @Test
    @DisplayName("Tests whether the vehicle is of the expected type")
    void getFahrzeug() {
        assertTrue(FahrzeugtypHelper.getFahrzeug(ZWEIRAD) instanceof Zweirad);
        assertTrue(FahrzeugtypHelper.getFahrzeug(TRIKE) instanceof Trike);
        assertTrue(FahrzeugtypHelper.getFahrzeug(QUAD) instanceof Quad);
        assertTrue(FahrzeugtypHelper.getFahrzeug(PKW) instanceof PKW);
        assertTrue(FahrzeugtypHelper.getFahrzeug(SUV) instanceof SUV);
        assertTrue(FahrzeugtypHelper.getFahrzeug(PICKUP) instanceof Pickup);
    }

    @Test
    @DisplayName("Checks whether null is returned if the vehicle is not defined")
    void getFahrzeug2() {
        assertEquals(null, FahrzeugtypHelper.getFahrzeug("ABC"));
    }

    @ParameterizedTest
    @DisplayName("Checks the surface method for Cartypes")
    @CsvSource({"1," + ZWEIRAD, "2," + TRIKE, "3," + QUAD, "4," + PKW, "5," + SUV, "6," + PICKUP})
    void getFlaecheTest(int in, String s) {
        assertEquals(in,FahrzeugtypHelper.getFahrzeug(s).getFlaeche());
    }

    @ParameterizedTest
    @DisplayName("Checks the fees method for Cartypes")
    @CsvSource({"0.5," + ZWEIRAD, "0.7," + TRIKE, "0.8," + QUAD, "1.0," + PKW, "1.3," + SUV, "1.5," + PICKUP})
    void getGebuehrenfaktorTest(double d, String s) {
        assertEquals(d,FahrzeugtypHelper.getFahrzeug(s).getGebuehrenfaktor());
    }

}