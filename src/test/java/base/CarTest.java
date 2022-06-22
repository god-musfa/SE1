package base;

import org.junit.jupiter.api.BeforeEach;
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
    void ticketCreation(){
        assertEquals("058e845e583d91de30e47b1f49c41411",car.getTicket().getTicketID());
    }
}