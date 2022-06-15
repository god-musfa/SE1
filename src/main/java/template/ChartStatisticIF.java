package template;

import base.CarIF;
import jakarta.json.JsonObject;

import java.util.List;

public interface ChartStatisticIF {
    JsonObject statistikErstellen(List<CarIF> car);
    List<Integer> valueBerechnen(List<CarIF> car, List<String> label);
    List<String> labelBerechnen(List<CarIF> car);
    JsonObject statistikAnzeigen(List<String> a, List<Integer> b);
}
