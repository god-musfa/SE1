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

    public static double calcAvgPrice(List<CarIF> carsList) {
        double number = carsList.stream()
                .filter(x -> !x.getKundentyp().equals("Abonnent"))
                .count();
        return (double) Math.round((calcSum(carsList)/number) * 100) / 100;
    }

    public static double calcSum(List<CarIF> carsList) {
        return carsList.stream()
                .filter(x -> !x.getKundentyp().equals("Abonnent"))
                .map(CarIF::getTicket)
                .map(TicketIF::getPrice)
                .mapToDouble(price -> price)
                .sum();
    }

    //@toDo add Method for AverageTime (sonderfall fuer Abonnenten faellt weg)
}
