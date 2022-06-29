package helper;

import base.CarIF;
import base.TicketIF;

import java.util.List;

public class ButtonCalc {

    public static double calcMax(List<CarIF> carsList) {
        return carsList.stream()
                .map(CarIF::getTicket)
                .map(TicketIF::getPrice)
                .filter(price -> price > 0.0)
                .mapToDouble(price -> price)
                .max().orElse(Double.MIN_VALUE);
    }

}
