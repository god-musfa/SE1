package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {
    String[] st1;
    String[] st2;
    String[] st3;
    ParkhausIF ph;
    Car c1;
    Car c2;
    Car c3;

    @BeforeEach
    void setUp() {
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","Behinderte","Trike"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","Firmenkunde","Quad"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","Parkhauskunde","Zweirad"};
        ph = new Parkhaus(15);
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);
    }

    @Test
    @DisplayName("Tests if cars are correctly added to the parking garage")
    void enterTest() {
        assertEquals(1,ph.enter(c1));
        assertEquals(2,ph.enter(c2));
        assertEquals(3,ph.enter(c3));
    }

    @Test
    @DisplayName("Tests whether cars are correctly removed from the parking garage")
    void leaveTest() {
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);
        assertEquals(0.00,ph.leave(1,0));
        assertEquals(0.00,ph.leave(2,0));
        assertEquals(0.00,ph.leave(3,0));
        assertEquals(-1.00,ph.leave(4,0));
    }

    @Test
    @DisplayName("Tests whether cars can drive out although the parking garage is empty" )
    void leaveTest2() {
        assertEquals(-1.00,ph.leave(1,0));
    }
    @Test
    @DisplayName("Tests whether cars can drive out although they are not in the parking garage" )
    void leaveTest3() {
        ph.enter(c1);
        assertEquals(-1.00,ph.leave(2,0));
    }

    @Test
    @DisplayName("Checks whether cars are inserted at the expected position")
    void leaveEnterTest() {
        ph.enter(c1);
        ph.enter(c2);
        ph.leave(1,0);
        ph.enter(c3);
        assertEquals(c3.getNr(),ph.getCars()[0].getNr());
    }

    @Test
    @DisplayName("Checks for correct TicketID")
    void getTicket() {
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);

        assertEquals(ph.getTicket().get(0).getTicketID(),"as");
        assertEquals(ph.getTicket().get(1).getTicketID(),"ad");
        assertEquals(ph.getTicket().get(2).getTicketID(),"af");
    }


    @Test
    @DisplayName("Checks the correctness of the vehicle list")
    void getCarsList() {
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);

        List<CarIF> cars =  new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        assertEquals(cars,ph.getCarsList());
    }

    @Test
    @DisplayName("Check parking lot size")
    void getParkplatzSize() {
        assertEquals(15,ph.getParkingSpotSize());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,5,20})
    @DisplayName("Checks the change in maximum parking spaces")
    void changeMaxTest(int w) {
        ph.changeMax(w);
        assertEquals(w, ph.getParkingSpotSize());
    }

    @Test
    @DisplayName("Checks correctness of cars to string")
    void carsListToString() {
    assertEquals("",ph.carsListToString());

    ph.enter(c1);
    assertEquals(c1.toStringSeperatedBySlash(),ph.carsListToString());

    ph.enter(c2);
    assertEquals(c1.toStringSeperatedBySlash()+","+c2.toStringSeperatedBySlash(),ph.carsListToString());
    }

    @Test
    @DisplayName("Tests output with full parking lot")
    void enterFullParkhaus(){
        ph = new Parkhaus(2);
        ph.enter(c1);
        ph.enter(c2);
        assertEquals(-1,ph.enter(c3));

    }

    @Test
    @DisplayName("Checks the reset function for correctness")
    void reset() {
        ph.enter(c1);
        ph.enter(c2);
        assertEquals(false,ph.getCarsList().isEmpty());
        assertNotNull(ph.getCars()[0]);

        ph.reset();

        assertNull(ph.getCars()[0]);
        assertEquals(true,ph.getCarsList().isEmpty());
    }


    @AfterEach
    void tearDown() {
        st1 = null;
        st2 = null;
        st3 = null;
        ph = null;
        c1 = null;
        c2 = null;
        c3 = null;
    }
}