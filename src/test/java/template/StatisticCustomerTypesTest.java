package template;

import base.Car;
import base.CarIF;
import jakarta.json.Json;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticCustomerTypesTest {

    List<Integer> nums;
    List<String>  strings;
    List<CarIF> testvalues;
    List<String> labels;
    List<Integer> values;
    StatisticCustomerTypes statistic;
    StatisticCustomerTypes sct = new StatisticCustomerTypes();

    List<String> vergleichslisteWahr;

    List<String> vergleichslisteFalsch;
    @BeforeEach
    void setUp() {
        String[] st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","Frau","Pkw"};
        String[] st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","Abonnent","Suv"};

        nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        strings = new ArrayList<>(List.of("a", "b", "c", "d", "e"));

        Car testcar1 = new Car(st1);
        Car testcar2 = new Car(st2);
        Car testcar3 = new Car(st2);
        Car testcar4 = new Car(st1);
        Car testcar5 = new Car(st1);

        testvalues = new ArrayList<>();
        testvalues.add(testcar1);
        testvalues.add(testcar2);
        testvalues.add(testcar3);
        testvalues.add(testcar4);
        testvalues.add(testcar5);

        statistic = new StatisticCustomerTypes();


    }

    @Test
    void valueBerechnen() {
        List<Integer> valueVergleich = new ArrayList<>();
        valueVergleich.add(3);
        valueVergleich.add(2);

        values = statistic.calcValues(testvalues, statistic.calcValues(testvalues));
        assertEquals(valueVergleich, values);
    }

    @Test
    void labelBerechnen() {
        vergleichslisteWahr = new ArrayList<>(List.of("Frau","Abonnent"));
        vergleichslisteFalsch = new ArrayList<>(List.of("Familie","Parkhauskunde","Firmenkunde"));
        labels = statistic.calcValues(testvalues);

        assertEquals(vergleichslisteWahr,labels);
        assertNotEquals(vergleichslisteFalsch,labels);
    }

    @Test
    void createPieChart() {
        String test = "{\"data\":[{\"values\":" + Json.createArrayBuilder(nums).build().toString()+",\"labels\":" + Json.createArrayBuilder(strings).build().toString() +",\"type\":\"pie\"}]}";
        assertEquals(test,sct.buildPieChart(strings,nums).toString());
    }
    @Test
    void barChartTest(){
        assertEquals("{\"data\":[{\"values\":[3,2],\"labels\":[\"Frau\",\"Abonnent\"],\"type\":\"bar\"}]}",sct.createBarStatisticsJSON(testvalues).toString());

    }
    @Test
    void barChartTest2(){
        List<CarIF> tv = new ArrayList<>();
        assertEquals("{\"data\":[{\"values\":[],\"labels\":[],\"type\":\"bar\"}]}",sct.createBarStatisticsJSON(tv).toString());

    }
}