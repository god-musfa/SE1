package template;

import base.CarIF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticCustomerTypes extends ChartStatistic {
    @Override
    public List<Integer> calcValues(List<CarIF> car, List<String> label) {
        List<Integer> count = new ArrayList<>();
        for(String strings: label){
            count.add((int) car.stream()
                    .filter((CarIF c)  -> strings.equals(c.getKundentyp()))
                    .count());
        }
        return count;
    }

    @Override
    public List<String> calcValues(List<CarIF> car) {
        return car.stream().map(CarIF::getKundentyp).distinct().collect(Collectors.toList());
    }
}
