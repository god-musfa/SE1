package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugtypHelperTest {
    static final String zweirad = "Zweirad";
    static final String trike = "Trike";
    static final String quad = "Quad";
    static final String pkw = "PKW";
    static final String suv = "SUV";
    static final String pickup = "Pickup";

    @Test
    @DisplayName("Testet ob das Fahrzeug vom erwarteten Typ ist")
    void getFahrzeug() {
        assertTrue(FahrzeugtypHelper.getFahrzeug(zweirad) instanceof Zweirad);
        assertTrue(FahrzeugtypHelper.getFahrzeug(trike) instanceof Trike);
        assertTrue(FahrzeugtypHelper.getFahrzeug(quad) instanceof Quad);
        assertTrue(FahrzeugtypHelper.getFahrzeug(pkw) instanceof PKW);
        assertTrue(FahrzeugtypHelper.getFahrzeug(suv) instanceof SUV);
        assertTrue(FahrzeugtypHelper.getFahrzeug(pickup) instanceof Pickup);
    }

    @Test
    @DisplayName("Prueft ob null zurueckgegeben wird, wenn das Fahrzeug nicht definiert ist")
    void getFahrzeug_ungueltigesFahrzeug_fehlermeldung() {
        assertEquals(null, FahrzeugtypHelper.getFahrzeug("ABC"));
    }

    @Test
    @DisplayName("Prüft die getGebührenfaktor Methode")
    void getGebührenfaktorTest(){
        assertEquals(0.5,FahrzeugtypHelper.getFahrzeug(zweirad).getGebuehrenfaktor());
        assertEquals(0.7,FahrzeugtypHelper.getFahrzeug(trike).getGebuehrenfaktor());
        assertEquals(0.8,FahrzeugtypHelper.getFahrzeug(quad).getGebuehrenfaktor());
        assertEquals(1.0,FahrzeugtypHelper.getFahrzeug(pkw).getGebuehrenfaktor());
        assertEquals(1.3,FahrzeugtypHelper.getFahrzeug(suv).getGebuehrenfaktor());
        assertEquals(1.5,FahrzeugtypHelper.getFahrzeug(pickup).getGebuehrenfaktor());
    }

    @Test
    @DisplayName("Prüft die getFlaeche Methode")
    void getFlaecheTest(){
        assertEquals(1,FahrzeugtypHelper.getFahrzeug(zweirad).getFlaeche());
        assertEquals(2,FahrzeugtypHelper.getFahrzeug(trike).getFlaeche());
        assertEquals(3,FahrzeugtypHelper.getFahrzeug(quad).getFlaeche());
        assertEquals(4,FahrzeugtypHelper.getFahrzeug(pkw).getFlaeche());
        assertEquals(5,FahrzeugtypHelper.getFahrzeug(suv).getFlaeche());
        assertEquals(6,FahrzeugtypHelper.getFahrzeug(pickup).getFlaeche());
    }
}