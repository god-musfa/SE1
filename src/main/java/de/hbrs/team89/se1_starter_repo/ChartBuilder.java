package de.hbrs.team89.se1_starter_repo;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.List;

public class ChartBuilder {
    static JsonObject createPieChart(List<String> a, List<Integer> B) {

        JsonObject chart = Json.createObjectBuilder()
                .add("data", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("values", Json.createArrayBuilder(B).build())
                                .add("labels", Json.createArrayBuilder(a).build())
                                .add("type", "pie"))).build();

        return chart;
    }
}
