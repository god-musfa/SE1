package helper;

import base.CarIF;
import base.TicketIF;

import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Calculation class for buttons in the servlet
 */
public class ButtonCalc {
    private static final String ignoreCuTy = "Abonnent"; //ignoreCustomerType: Customer type that should not be included in the calculation

    private ButtonCalc() {
        //ButtonCalc is a Utility class
    }

    public static double calcMax(List<CarIF> carsList) {
        return calcPriceStream(carsList).filter(price -> price > 0.0)
                .max().orElse(0.0);
    }

    public static double calcMin(List<CarIF> carsList) {
        return calcPriceStream(carsList)
                .filter(price -> price > 0.0)
                .min().orElse(0.0);
    }

    public static double calcSum(List<CarIF> carsList) {
        return calcPriceStream(carsList).sum();
    }

    public static double calcAvgPrice(List<CarIF> carsList) {
        return (double) Math.round((calcSum(carsList)/calcAnzahl(carsList)) * 100) / 100;
    }

    public static double calcAvgDuration(List<CarIF> carsList) {
        long sumDur = carsList.stream()
                .filter(x -> !x.getKundentyp().equals(ignoreCuTy))
                .map(CarIF::getTicket)
                .map(TicketIF::duration)
                .mapToLong(duration -> duration)
                .sum();
        return (double) Math.round((sumDur/calcAnzahl(carsList)) * 100) / 100;
    }

    private static double calcAnzahl(List<CarIF> carsList) {
        return carsList.stream().filter(x -> !x.getKundentyp().equals(ignoreCuTy)).filter(x -> x.getTicket().getEnd() != null).count();
    }

    private static DoubleStream calcPriceStream(List<CarIF> carsList) {
        return carsList.stream()
                .filter(x -> !x.getKundentyp().equals(ignoreCuTy))
                .map(CarIF::getTicket)
                .map(TicketIF::getPrice)
                .mapToDouble(price -> price);
    }

}
