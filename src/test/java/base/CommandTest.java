package base;

import command.Enter;
import command.ICommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","Frau","PKW"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","Familie","SUV"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","Abonnent","Pickup"};
        ph = new Parkhaus(15);
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
    @DisplayName("Überprüft ob Commands in richtiger Reihenfolge eingefügt werden")
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

    @DisplayName("Undo Methode wird geprüft")
    @Test
    void undoTest(){
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);
        ArrayList<Enter> x = ph.getEnterCommand();
        ArrayList<ICommand> y= ph.getCommand();

        assertTrue(x.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c3));
        assertTrue(y.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c3)); // check if c3 is in Enter and Command Lists
        ph.undo();

        assertFalse(x.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c3));
        assertFalse(y.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c3));
        assertFalse(Arrays.asList(ph.getCars()).contains(c3));

        ph.undo();

        assertFalse(x.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c2));
        assertFalse(y.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c2));
        assertFalse(Arrays.asList(ph.getCars()).contains(c2));


    }
    @DisplayName("Undo Methode darf keine Wirksamkeit bei rausgefahrenen Autos haben")
    @Test
    void noUndoAfterLeaveTest(){
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);
        ArrayList<Enter> x = ph.getEnterCommand();
        ArrayList<ICommand> y= ph.getCommand();

        ph.leave(c3.nr(),0);
        assertFalse(x.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c3));
        assertTrue(y.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c3));
        ph.undo();
        assertFalse(x.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c2));
        assertFalse(y.stream().map(ICommand::getCar).collect(Collectors.toList()).contains(c2));
    }

}
