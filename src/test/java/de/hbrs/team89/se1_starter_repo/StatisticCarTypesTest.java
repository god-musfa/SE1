package de.hbrs.team89.se1_starter_repo;

import jakarta.json.Json;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticCarTypesTest {
    List<Integer> nums;
    List<String>  strings;
    StatisticCarTypes sct = new StatisticCarTypes();
    @BeforeEach
    void setUp() {
    nums = new ArrayList<>(List.of(new Integer[]{1, 2, 3, 4, 5}));
    strings = new ArrayList<>(List.of(new String[]{"a", "b", "c", "d", "e"}));
    }

    @Test
    void createPieChart() {
        String test = "{\"data\":[{\"values\":" + Json.createArrayBuilder(nums).build().toString()+",\"labels\":" + Json.createArrayBuilder(strings).build().toString() +",\"type\":\"pie\"}]}";
        assertEquals(test,sct.statistikAnzeigen(strings,nums).toString());





    }
}