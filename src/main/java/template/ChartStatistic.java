package template;

import base.CarIF;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.List;

public abstract class ChartStatistic implements ChartStatisticIF {
    @Override
    public final JsonObject statistikErstellen(List<CarIF> car) {
        List<String> label = labelBerechnen(car);
        List<Integer> value = valueBerechnen(car, label);
        return statistikAnzeigen(label, value);
    }

    @Override
    public JsonObject statistikAnzeigen(List<String> a, List<Integer> b) {
        return Json.createObjectBuilder()
                .add("data", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("values", Json.createArrayBuilder(b).build())
                                .add("labels", Json.createArrayBuilder(a).build())
                                .add("type", "pie"))).build();

    }
}
