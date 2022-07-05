package template;

import base.CarIF;
import jakarta.json.JsonObject;

import java.util.List;

public interface ChartStatisticIF {
    JsonObject createPieStatisticsJSON(List<CarIF> car);
    List<Integer> calcValues(List<CarIF> car, List<String> label);
    List<String> calcValues(List<CarIF> car);

    JsonObject createBarStatisticsJSON(List<CarIF> car);

    JsonObject buildPieChart(List<String> a, List<Integer> b);
    JsonObject buildBarChart(List<String> a, List<Integer> b);
}
