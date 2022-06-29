package helper;

import base.CarIF;
import base.TicketIF;

import java.util.List;

/**
 * Calculation class for buttons in the servlet
 */
public class ButtonCalc {

    public static double calcMax(List<CarIF> carsList) {
        return carsList.stream()
                .filter(x -> !x.getKundentyp().equals("Abonnent"))
                .map(CarIF::getTicket)
                .map(TicketIF::getPrice)
                .filter(price -> price > 0.0)
                .mapToDouble(price -> price)
                .max().orElse(0.0);
    }

    public static double calcMin(List<CarIF> carsList) {
        return carsList.stream()
                .filter(x -> !x.getKundentyp().equals("Abonnent"))
                .map(CarIF::getTicket)
                .map(TicketIF::getPrice)
                .filter(price -> price > 0.0)
                .mapToDouble(price -> price)
                .min().orElse(0.0);
    }

}
