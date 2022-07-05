package template;

import base.CarIF;
import jakarta.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class GroupedIncomeStatistic extends ChartStatistic {

    @Override
    public List<Integer> calcValues(List<CarIF> car, List<String> label) {
        List<Integer> count = new ArrayList<>();
        int i = 1;
        for (String strings : label) {
            if (i == label.size()) {
                count.add((int) car.stream()
                        .filter((CarIF c) -> c.getTicket().getPrice() >= Integer.parseInt(strings))
                        .count());
            }
             else {
                int finalI = i;
                System.out.println(finalI);
                count.add((int) car.stream()
                        .filter((CarIF c) -> (c.getTicket().getPrice() >= Integer.parseInt(strings) && c.getTicket().getPrice() < Integer.parseInt(label.get(finalI))))
                        .count());
                i++;
            }
        }
        return count;
    }
    @Override
    public List<String> calcValues(List<CarIF> car) {
        return List.of(new String[]{"5", "10", "15"});
    }
}
