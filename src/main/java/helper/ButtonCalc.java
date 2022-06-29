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
        return (double) Math.round((calcSum(carsList)/calcAnzahl(carsList)) * 100) / 100;
    }

    public static double calcAvgDuration(List<CarIF> carsList) {
        long sumDur = carsList.stream()
                .filter(x -> !x.getKundentyp().equals("Abonnent"))
                .map(CarIF::getTicket)
                .map(TicketIF::duration)
                .mapToLong(duration -> duration)
                .sum();
        return (double) Math.round((sumDur/calcAnzahl(carsList)) * 100) / 100;
    }

    private static double calcAnzahl(List<CarIF> carsList) {
        return carsList.stream().filter(x -> !x.getKundentyp().equals("Abonnent")).filter(x -> x.getTicket().getEnd() != null).count();
    }

    public static double calcSum(List<CarIF> carsList) {
        return carsList.stream()
                .filter(x -> !x.getKundentyp().equals("Abonnent"))
                .map(CarIF::getTicket)
                .map(TicketIF::getPrice)
                .mapToDouble(price -> price)
                .sum();
    }
}
