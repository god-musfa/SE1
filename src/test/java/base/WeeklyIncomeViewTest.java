package base;

import mvc.WeeklyIncomeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeeklyIncomeViewTest {

    Parkhaus ph;
    WeeklyIncomeView wi;
    Car c1;
    Car c2;
    Car c3;
    String[] st1;
    String[] st2;
    String[] st3;
    @BeforeEach
    void setUp() {
        ph = new Parkhaus();
        wi =new WeeklyIncomeView(ph);
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","dfds","sadas"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","sddd","gmgj"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","bgfs","fff"};
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);
        c1.getTicket().setPrice(100);
        c2.getTicket().setPrice(1500);
        c3.getTicket().setPrice(400);

        long unix = 1654704862;
        c1.getTicket().setEnd(unix);
        c2.getTicket().setEnd(unix);
        c3.getTicket().setEnd(unix+86401);
    }
    @Test
    void update() {
        wi.enterCar(c1);
        wi.enterCar(c2);
        wi.enterCar(c3);
        assertEquals(400.00,wi.getWeeklyIncome());

    }




}