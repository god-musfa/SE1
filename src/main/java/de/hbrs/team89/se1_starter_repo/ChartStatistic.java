package de.hbrs.team89.se1_starter_repo;

import jakarta.json.JsonObject;

import java.util.List;

public abstract class ChartStatistic implements ChartStatisticIF {
    @Override
    final public JsonObject statistikErstellen(List<CarIF> car) {
        List<String> label = labelBerechnen(car);
        List<Integer> value = valueBerechnen(car, label);
        return statistikAnzeigen(label, value);
    }

    @Override
    abstract public List<Integer> valueBerechnen(List<CarIF> car, List<String> label);

    @Override
    abstract public List<String> labelBerechnen(List<CarIF> car);

    @Override
    public JsonObject statistikAnzeigen(List<String> a, List<Integer> b) {
        return null;
    }


}
