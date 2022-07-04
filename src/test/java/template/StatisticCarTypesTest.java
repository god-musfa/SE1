package template;

import base.Car;
import base.CarIF;
import org.junit.jupiter.api.DisplayName;
import jakarta.json.Json;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticCarTypesTest {
    List<Integer> nums;
    List<String>  strings;
    List<CarIF> testvalues;
    List<String> labels;
    List<Integer> values;
    StatisticCarTypes statistic;
    StatisticCarTypes sct = new StatisticCarTypes();

    List<String> vergleichslisteWahr;

    List<String> vergleichslisteFalsch;
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

    testvalues = new ArrayList<>();
    testvalues.add(testcar1);
    testvalues.add(testcar2);
    testvalues.add(testcar3);
    testvalues.add(testcar4);
    testvalues.add(testcar5);

    statistic = new StatisticCarTypes();


    }

    @Test
    void createPieChart() {
        String test = "{\"data\":[{\"values\":" + Json.createArrayBuilder(nums).build().toString()+",\"labels\":" + Json.createArrayBuilder(strings).build().toString() +",\"type\":\"pie\"}]}";
        assertEquals(test,sct.statistikAnzeigen(strings,nums).toString());
    }

    @Test
    void valueBerechnen() {
    List<Integer> valueVergleich = new ArrayList<>();
    valueVergleich.add(3);
    valueVergleich.add(2);

    values = statistic.valueBerechnen(testvalues, statistic.labelBerechnen(testvalues));
    assertEquals(valueVergleich, values);
    }

    @Test
    void labelBerechnen() {
        vergleichslisteWahr = new ArrayList<>(List.of("Pkw","Suv"));
        vergleichslisteFalsch = new ArrayList<>(List.of("Pkw","Suv","Zweirad"));
        labels = statistic.labelBerechnen(testvalues);

        assertEquals(vergleichslisteWahr,labels);
        assertNotEquals(vergleichslisteFalsch,labels);
    }

    @Test
    @DisplayName("Testet gefuelltes statistikErstellen")
    void statistikErstellenTest() {
        assertEquals("{\"data\":[{\"values\":[3,2],\"labels\":[\"Pkw\",\"Suv\"],\"type\":\"pie\"}]}",sct.statistikErstellen(testvalues).toString());
    }

    @Test
    @DisplayName("Testet leeres statistikErstellen")
    void statistikErstellenTest2() {
        List<CarIF> tv = new ArrayList<>();
        assertEquals("{\"data\":[{\"values\":[],\"labels\":[],\"type\":\"pie\"}]}",sct.statistikErstellen(tv).toString());
    }

}