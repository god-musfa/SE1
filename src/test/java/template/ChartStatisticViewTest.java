package template;

import base.Car;
import base.Parkhaus;
import mvc.DailyIncomeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChartStatisticViewTest {
    Parkhaus ph;
    ChartStatisticView wi;
    Car c1;
    Car c2;
    Car c3;
    String[] st1;
    String[] st2;
    String[] st3;

    @BeforeEach
    void setUp() {
        ph = new Parkhaus(15);
        wi = new ChartStatisticView(ph);
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","Frau","SUV"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","Parkhauskunde","SUV"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","Frau","PKW"};
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);
        c1.getTicket().setPrice(100);
        c2.getTicket().setPrice(1500);
        c3.getTicket().setPrice(401);


        c1.getTicket().setDuration(0);
        c2.getTicket().setDuration(1);
        c3.getTicket().setDuration(86400);
    }


    @Test
    void update() {
        wi.enter(c1);
        wi.enter(c2);
        wi.enter(c3);

        assertEquals("{\"data\":[{\"values\":[2,1],\"labels\":[\"SUV\",\"PKW\"],\"type\":\"pie\"}]}",wi.getPieChart().toString());
    }
    @Test
    void leaveTest(){
        wi.enter(c1);
        wi.enter(c2);
        wi.enter(c3);
        assertEquals(0,wi.leave(1,0));
    }
}