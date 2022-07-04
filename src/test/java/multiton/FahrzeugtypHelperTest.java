package multiton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugtypHelperTest {
    static final String zweirad = "zr";

    @Test
    @DisplayName("Testet ob das Fahrzeug vom erwarteten Typ ist")
    void getFahrzeug() {
        assertTrue(FahrzeugtypHelper.getFahrzeug("zr") instanceof Zweirad);
        assertTrue(FahrzeugtypHelper.getFahrzeug("Trike") instanceof Trike);
        assertTrue(FahrzeugtypHelper.getFahrzeug("Quad") instanceof Quad);
        assertTrue(FahrzeugtypHelper.getFahrzeug("PKW") instanceof PKW);
        assertTrue(FahrzeugtypHelper.getFahrzeug("SUV") instanceof SUV);
        assertTrue(FahrzeugtypHelper.getFahrzeug("Pickup") instanceof Pickup);
    }

    @Test
    @DisplayName("Prueft ob null zurueckgegeben wird, wenn das Fahrzeug nicht definiert ist")
    void getFahrzeug_ungueltigesFahrzeug_fehlermeldung() {
        assertEquals(null, FahrzeugtypHelper.getFahrzeug("ABC"));
    }

    @Test
    @DisplayName("Prüft die getGebührenfaktor Methode")
    void getGebührenfaktorTest(){
        assertEquals(0.5,FahrzeugtypHelper.getFahrzeug("zr").getGebuehrenfaktor());
        assertEquals(0.7,FahrzeugtypHelper.getFahrzeug("Trike").getGebuehrenfaktor());
        assertEquals(0.8,FahrzeugtypHelper.getFahrzeug("Quad").getGebuehrenfaktor());
        assertEquals(1.0,FahrzeugtypHelper.getFahrzeug("PKW").getGebuehrenfaktor());
        assertEquals(1.3,FahrzeugtypHelper.getFahrzeug("SUV").getGebuehrenfaktor());
        assertEquals(1.5,FahrzeugtypHelper.getFahrzeug("Pickup").getGebuehrenfaktor());
    }

    @Test
    @DisplayName("Prüft die getFlaeche Methode")
    void getFlaecheTest(){
        assertEquals(1,FahrzeugtypHelper.getFahrzeug("zr").getFlaeche());
        assertEquals(2,FahrzeugtypHelper.getFahrzeug("Trike").getFlaeche());
        assertEquals(3,FahrzeugtypHelper.getFahrzeug("Quad").getFlaeche());
        assertEquals(4,FahrzeugtypHelper.getFahrzeug("PKW").getFlaeche());
        assertEquals(5,FahrzeugtypHelper.getFahrzeug("SUV").getFlaeche());
        assertEquals(6,FahrzeugtypHelper.getFahrzeug("Pickup").getFlaeche());
    }
}