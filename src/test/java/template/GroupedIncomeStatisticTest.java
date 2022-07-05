package template;

import base.Car;
import base.CarIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupedIncomeStatisticTest {
    List<Integer> nums;
    List<String>  strings;
    List<CarIF> testvalues;
    List<String> labels;
    List<Integer> values;
    GroupedIncomeStatistic statistic;
    @BeforeEach
    void setUp() {
        String[] st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","dfds","Pkw"};
        String[] st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","sddd","Suv"};

        nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        strings = new ArrayList<>(List.of("a", "b", "c", "d", "e"));

        Car testcar1 = new Car(st1);
        Car testcar2 = new Car(st2);
        Car testcar3 = new Car(st2);
        Car testcar4 = new Car(st1);
        Car testcar5 = new Car(st1);
        testcar1.getTicket().setPrice(13);
        testcar2.getTicket().setPrice(10);
        testcar3.getTicket().setPrice(6);
        testcar4.getTicket().setPrice(25);
        testcar5.getTicket().setPrice(10);
        testvalues = new ArrayList<>();
        testvalues.add(testcar1);
        testvalues.add(testcar2);
        testvalues.add(testcar3);
        testvalues.add(testcar4);
        testvalues.add(testcar5);

        statistic = new GroupedIncomeStatistic();
    }

    @Test
    void calcValues() {
        assertEquals(List.of("5", "10", "15"),statistic.calcValues(testvalues));

    }

    @Test
    void testCalcValues() {
       List<Integer> res = statistic.calcValues(testvalues,statistic.calcValues(testvalues));
       assertEquals(List.of(1,3,1),res);
    }

    @Test
    void createPieChartTest(){
        assertEquals("{\"data\":[{\"values\":[1,3,1],\"labels\":[\"5\",\"10\",\"15\"],\"type\":\"bar\"}]}",statistic.createBarStatisticsJSON(testvalues).toString());
    }
}