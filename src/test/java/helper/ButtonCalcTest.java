package helper;

import base.Car;
import base.CarIF;
import junit.framework.Assert;
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
                new Car(new String[] {"6","1651072643200","_","19","058e845e583d91de30e47b1f49c41411","#7eecf5","1","Frau","SUV","SU-Z 15"}),
                new Car(new String[] {"6","1651072643100","_","19","058e845e583d91de30e47b1f49c41412","#7eecf6","1","Frau","SUV","SU-Z 16"}),
                new Car(new String[] {"6","1651072643250","_","19","058e845e583d91de30e47b1f49c41413","#7eecf7","1","Frau","SUV","SU-Z 17"}),
                new Car(new String[] {"6","1651072643184","_","19","058e845e583d91de30e47b1f49c41414","#7eecf8","1","Abonnent","SUV","SU-Z 18"}),
                new Car(new String[] {"4","1651072643260","_","19","058e845e583d91de30e47b1f49c41415","#7eecf9","1","Firmenkunde","SUV","SU-Z 19"})
        };
        c[0].getTicket().setPrice(2);
        c[1].getTicket().setPrice(10);
        c[2].getTicket().setPrice(5);
        c[3].getTicket().setPrice(1);
        c[4].getTicket().setPrice(0);
        c[0].getTicket().setDuration(Long.parseLong("100"));
        c[1].getTicket().setDuration(Long.parseLong("1"));
        c[2].getTicket().setDuration(Long.parseLong("150"));
        carsList.add(c[0]);
        carsList.add(c[1]);
        carsList.add(c[2]);
        carsList.add(c[3]);
        carsList.add(c[4]);
    }

    @Test
    @DisplayName("Checks whether the most expensive amount paid is returned")
    void calcMax() {
        assertEquals(10.0, ButtonCalc.calcMax(carsList));
    }

    @Test
    @DisplayName("Checks whether the cheapest amount paid is returned")
    void calcMin() {
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

    @Test
    @DisplayName("Checks whether the average Duration is returned")
    void calcAvgDuration() {
        assertEquals(83.67, ButtonCalc.calcAvgDuration(carsList));
    }

    @Test
    @DisplayName("Checks the output if the List is empty")
    void emptyObject() {
        List<CarIF> carsListEmpty = new ArrayList<>();
        assertEquals(0.0, ButtonCalc.calcMax(carsListEmpty));
        assertEquals(0.0, ButtonCalc.calcMin(carsListEmpty));
        assertEquals(0.0, ButtonCalc.calcSum(carsListEmpty));
        assertEquals(0.0, ButtonCalc.calcAvgPrice(carsListEmpty));
        assertEquals(0.0, ButtonCalc.calcAvgDuration(carsListEmpty));
    }

    @Test
    @DisplayName("Checks whether the sum of all Cars counted is returned")
    void calcGesamtAnzahlAutos() {
        Assert.assertEquals(5,ButtonCalc.calcGesamtAnzahlAutos(carsList));
    }
}