package base;

import mvc.DailyIncomeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyIncomeViewTest {

    Parkhaus ph;
    DailyIncomeView wi;
    Car c1;
    Car c2;
    Car c3;
    String[] st1;
    String[] st2;
    String[] st3;
    @BeforeEach
    void setUp() {
        ph = new Parkhaus(15);
        wi = new DailyIncomeView(ph);
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","dfds","sadas"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","sddd","gmgj"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","bgfs","fff"};
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);
        c1.getTicket().setPrice(100);
        c2.getTicket().setPrice(1500);
        c3.getTicket().setPrice(400);


        c1.getTicket().setDuration(0);
        c2.getTicket().setDuration(0);
        c3.getTicket().setDuration(86400);
    }
    @Test
    void update() {
        wi.enterCar(c1);
        wi.enterCar(c2);
        wi.enterCar(c3);
        assertEquals(2000.00,wi.getDailyIncome());

    }

    @Test
    @DisplayName("Testet die removeObserver Methode")
    void removeObserverTest(){
        wi.enterCar(c1);
        wi.enterCar(c2);
        wi.enterCar(c3);

        assertFalse(ph.getObservers().isEmpty());
        ph.removeObserver(wi);
        assertTrue(ph.getObservers().isEmpty());

    }
    @Test
    void removeNonExistentObserver(){
        wi.enterCar(c1);
        ph.removeObserver(wi);
        ph.removeObserver(wi);
        assertTrue((ph.getObservers().isEmpty()));
    }

}