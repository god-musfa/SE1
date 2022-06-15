package base;

import command.ICommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class CommandTest {
    String[] st1;
    String[] st2;
    String[] st3;
    ParkhausIF ph;
    Car c1;
    Car c2;
    Car c3;

    @BeforeEach
    void setUp() {
        st1 = new String[]{"1", "2", "3", "ab","as"};
        st2 = new String[]{"2", "2", "3","ab","ad"};
        st3 = new String[]{"3", "2", "3","ab","af"};
        ph = new Parkhaus();
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);
    }

    @AfterEach
    void tearDown() {
        st1 = null;
        st2 = null;
        st3 = null;
        ph = null;
        c1 = null;
        c2 = null;
        c3 = null;
    }
    @Test
    void commandTest(){
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);

        ArrayList<ICommand> a = ph.getCommand();
        assertEquals(c1,a.get(0).getCar());
        assertEquals(c2,a.get(1).getCar());
        assertEquals(c3,a.get(2).getCar());
    }
}
