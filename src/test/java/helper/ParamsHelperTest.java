package helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParamsHelperTest {
    String[] params;
    @BeforeEach
    void setUp() {
    params = new String[]{"2","1656953867960","_","_","79978abed24073fea1acdac913a069ab","#402513","5","Frau","SUV","SU-V 15","1656953921978","Etage1"};
    }

    @Test
    void getNr() {
        assertEquals("2",ParamsHelper.getNr(params));
    }

    @Test
    void getTimer() {
        assertEquals("1656953867960",ParamsHelper.getTimer(params));
    }

    @Test
    void getDuration() {
        assertEquals("_",ParamsHelper.getDuration(params));
    }

    @Test
    void getPrice() {
        assertEquals("_",ParamsHelper.getPrice(params));
    }

    @Test
    void getHashForTicket() {
        assertEquals("79978abed24073fea1acdac913a069ab",ParamsHelper.getHashForTicket(params));
    }

    @Test
    void getColor() {
        assertEquals("#402513",ParamsHelper.getColor(params));

    }
    @Test
    void getSpace() {
        assertEquals("5",ParamsHelper.getSpace(params));
    }
    @Test
    void getClientCategory() {
        assertEquals("Frau",ParamsHelper.getClientCategory(params));
    }

    @Test
    void getVehicleType() {
        assertEquals("SUV",ParamsHelper.getVehicleType(params));
    }

    @Test
    void getLicense() {
        assertEquals("SU-V 15",ParamsHelper.getLicense(params));
    }

    @Test
    void getBegin() {
        assertEquals("1656953921978",ParamsHelper.getBegin(params));
    }

    @Test
    void getParkhausName() {
        assertEquals("Etage1",ParamsHelper.getParkhausName(params));

    }

}