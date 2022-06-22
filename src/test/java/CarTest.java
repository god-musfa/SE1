import Multiton.*;
import base.Car;
import base.CarIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    CarIF car;
    @BeforeEach
    void setUp(){
        String[] params = {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Frau","SUV","SU-Z 15"};
        car = new Car(params);
    }

    @Test
    void nrTest() {
        assertEquals(6,car.nr());
    }

    @Test
    void begin() {
        fail("not yet implemented");
    }

    @Test
    void end() {
        fail("not yet implemented");
    }

    @Test
    void duration() {
        fail("not yet implemented");
    }

    @Test
    void price() {
        fail("not yet implemented");
    }

    @Test
    void ticketCreation(){
        assertEquals("058e845e583d91de30e47b1f49c41411",car.getTicket().getTicketID());
    }

    static class FahrzeugtypHelperTest {

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
}