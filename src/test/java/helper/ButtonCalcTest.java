package helper;

import base.Car;
import base.CarIF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ButtonCalcTest {
    List<CarIF> carsList;

    @BeforeEach
    void setUp() {
        carsList = new ArrayList<>();
        CarIF[] c = new Car[] {
                new Car(new String[] {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Frau","SUV","SU-Z 15"}),
                new Car(new String[] {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Frau","SUV","SU-Z 15"}),
                new Car(new String[] {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Frau","SUV","SU-Z 15"})
        };
        c[0].getTicket().setPrice(2);
        c[1].getTicket().setPrice(10);
        c[2].getTicket().setPrice(5);
        carsList.add(c[0]);
        carsList.add(c[1]);
        carsList.add(c[2]);
    }

    @Test
    @DisplayName("Checks whether the most expensive amount paid is returned")
    void calcMax() {
        assertEquals(10.0, ButtonCalc.calcMax(carsList));
    }

    @Test
    @DisplayName("Checks whether subscribers are not considered as planned (for calcMax)")
    void calcMax_subscriber() {
        CarIF c = new Car(new String[] {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Abonnent","SUV","SU-Z 15"});
        c.getTicket().setPrice(20000);
        carsList.add(c);
        assertEquals(10.0, ButtonCalc.calcMax(carsList));
    }

    @Test
    @DisplayName("Checks whether the cheapest amount paid is returned")
    void calcMin() {
        assertEquals(2.0, ButtonCalc.calcMin(carsList));
    }

    @Test
    @DisplayName("Checks whether subscribers are not considered as planned (for calcMin)")
    void calcMin_subscriber() {
        CarIF c = new Car(new String[] {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Abonnent","SUV","SU-Z 15"});
        c.getTicket().setPrice(1);
        carsList.add(c);
        assertEquals(2.0, ButtonCalc.calcMin(carsList));
    }

    @Test
    @DisplayName("Checks whether the average paid Price is returned")
    void calcAvgPrice() {
        assertEquals(5.67, ButtonCalc.calcAvgPrice(carsList));
    }

    @Test
    @DisplayName("Checks whether the sum is returned")
    void calcSum() {
        assertEquals(17.0, ButtonCalc.calcSum(carsList));
    }

    //@toDo Test falls ein leeres Objekt uebergeben wird hinzufuegen
}