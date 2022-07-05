package template;

import base.CarIF;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.List;

public abstract class ChartStatistic implements ChartStatisticIF {
    @Override
    public final JsonObject createPieStatisticsJSON(List<CarIF> car) {
        List<String> label = calcValues(car);
        List<Integer> value = calcValues(car, label);
        return buildPieChart(label, value);
    }
    @Override
    public final JsonObject createBarStatisticsJSON(List<CarIF> car) {
        List<String> label = calcValues(car);
        List<Integer> value = calcValues(car, label);
        return buildBarChart(label, value);
    }

    @Override
    public JsonObject buildPieChart(List<String> a, List<Integer> b) {
        return Json.createObjectBuilder()
                .add("data", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("values", Json.createArrayBuilder(b).build())
                                .add("labels", Json.createArrayBuilder(a).build())
                                .add("type", "pie"))).build();

    }
    public JsonObject buildBarChart(List<String> a, List<Integer> b) {
        return Json.createObjectBuilder()
                .add("data", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("values", Json.createArrayBuilder(b).build())
                                .add("labels", Json.createArrayBuilder(a).build())
                                .add("type", "bar"))).build();

    }
}
