package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugtypHelperTest {
    static final String ZWEIRAD = "Zweirad";
    static final String TRIKE = "Trike";
    static final String QUAD = "Quad";
    static final String PKW = "PKW";
    static final String SUV = "SUV";
    static final String PICKUP = "Pickup";

    @Test
    @DisplayName("Testet ob das Fahrzeug vom erwarteten Typ ist")
    void getFahrzeug() {
        assertTrue(FahrzeugtypHelper.getFahrzeug(ZWEIRAD) instanceof Zweirad);
        assertTrue(FahrzeugtypHelper.getFahrzeug(TRIKE) instanceof Trike);
        assertTrue(FahrzeugtypHelper.getFahrzeug(QUAD) instanceof Quad);
        assertTrue(FahrzeugtypHelper.getFahrzeug(PKW) instanceof PKW);
        assertTrue(FahrzeugtypHelper.getFahrzeug(SUV) instanceof SUV);
        assertTrue(FahrzeugtypHelper.getFahrzeug(PICKUP) instanceof Pickup);
    }

    @Test
    @DisplayName("Prueft ob null zurueckgegeben wird, wenn das Fahrzeug nicht definiert ist")
    void getFahrzeug_ungueltigesFahrzeug_fehlermeldung() {
        assertEquals(null, FahrzeugtypHelper.getFahrzeug("ABC"));
    }

    @Test
    @DisplayName("Prüft die getGebührenfaktor Methode")
    void getGebuehrenfaktorTest(){
        assertEquals(0.5,FahrzeugtypHelper.getFahrzeug(ZWEIRAD).getGebuehrenfaktor());
        assertEquals(0.7,FahrzeugtypHelper.getFahrzeug(TRIKE).getGebuehrenfaktor());
        assertEquals(0.8,FahrzeugtypHelper.getFahrzeug(QUAD).getGebuehrenfaktor());
        assertEquals(1.0,FahrzeugtypHelper.getFahrzeug(PKW).getGebuehrenfaktor());
        assertEquals(1.3,FahrzeugtypHelper.getFahrzeug(SUV).getGebuehrenfaktor());
        assertEquals(1.5,FahrzeugtypHelper.getFahrzeug(PICKUP).getGebuehrenfaktor());
    }

    @Test
    @DisplayName("Prüft die getFlaeche Methode")
    void getFlaecheTest(){
        assertEquals(1,FahrzeugtypHelper.getFahrzeug(ZWEIRAD).getFlaeche());
        assertEquals(2,FahrzeugtypHelper.getFahrzeug(TRIKE).getFlaeche());
        assertEquals(3,FahrzeugtypHelper.getFahrzeug(QUAD).getFlaeche());
        assertEquals(4,FahrzeugtypHelper.getFahrzeug(PKW).getFlaeche());
        assertEquals(5,FahrzeugtypHelper.getFahrzeug(SUV).getFlaeche());
        assertEquals(6,FahrzeugtypHelper.getFahrzeug(PICKUP).getFlaeche());
    }
}