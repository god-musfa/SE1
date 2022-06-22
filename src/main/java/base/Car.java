package base;

import multiton.Fahrzeugtyp;
import multiton.FahrzeugtypHelper;

import java.util.Arrays;

// ToDo replace 0 by correct values read from this.params
public class Car implements CarIF {
    String[] params;
    Fahrzeugtyp ft;
    Ticket t;
    public Car( String[] params ){
        this.params = params;
        ft = FahrzeugtypHelper.getFahrzeug(this.params[8]);
        t = new Ticket(this.params[4], this.params[1]);
    }

    @Override
    public int nr() {
        int x = Integer.parseInt(params[0]);
        return x;
    }

    public String getType(){
        return params[8];
    }

    @Override
    public Ticket getTicket() {
        return t;
    }


    @Override
    public String toString(){
        return Arrays.toString( params );
    }
}
