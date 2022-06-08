package de.hbrs.team89.se1_starter_repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticCarTypes extends ChartStatistic {
    @Override
    public List<Integer> valueBerechnen(List<CarIF> car, List<String> label) {
        List<Integer> count = new ArrayList<>();
        for(String strings: label){
            count.add((int) car.stream()
                    .filter((CarIF c)  -> strings.equals(c.getType()))
                    .count());
        }
        return count;
    }

    @Override
    public List<String> labelBerechnen(List<CarIF> car) {
        return car.stream().map(y->y.getType()).distinct().collect(Collectors.toList());
    }
}
