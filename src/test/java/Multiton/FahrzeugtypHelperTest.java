package Multiton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugtypHelperTest {

    @Test
    @DisplayName("Testet ob das Fahrzeug vom erwarteten Typ ist")
    void getFahrzeug() {
        assertTrue(FahrzeugtypHelper.getFahrzeug("Zweirad") instanceof Zweirad);
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

}