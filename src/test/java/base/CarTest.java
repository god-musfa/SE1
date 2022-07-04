package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    CarIF car;
    String[] params;
    @BeforeEach
    void setUp(){
        params = new String[]{"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Frau","SUV","SU-Z 15"};
        car = new Car(params);
    }

    @Test
    @DisplayName("Tests whether car.nr returns right value")
    void nrTest() {
        assertEquals(6,car.getNr());
    }

    @Test
    @DisplayName("Tests the ticketId is saved right in the creationprocess")
    void ticketCreation(){
        assertEquals("058e845e583d91de30e47b1f49c41411",car.getTicket().getTicketID());
    }

    @Test
    void getKundentyp() {
        assertEquals("Frau", car.getKundentyp());
    }

    @Test
    void toStringSeperatedBySlash() {
        assertEquals("6/1651072643184/0/0.0/058e845e583d91de30e47b1f49c41411/#7eecf5/1/Frau/SUV/SU-Z 15",car.toStringSeperatedBySlash());
    }

    @Test
    void setParkplatzNumber() {
        car.setParkplatzNumber(2);
        assertEquals("2",car.getSpace());
    }
}