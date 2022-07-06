package template;

import base.Car;
import base.Parkhaus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChartStatisticsCarTypesViewTest {
    Parkhaus ph;
    ChartStatisticsCarTypesView wi;
    Car c1;
    Car c2;
    Car c3;
    String[] st1;
    String[] st2;
    String[] st3;

    @BeforeEach
    void setUp() {
        ph = new Parkhaus(15);
        wi = new ChartStatisticsCarTypesView(ph);
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","Frau","SUV"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","Parkhauskunde","SUV"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","Frau","PKW"};
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);

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