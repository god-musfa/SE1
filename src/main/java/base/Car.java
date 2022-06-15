package base;

import java.util.Arrays;

// ToDo replace 0 by correct values read from this.params
public class Car implements CarIF {
    String[] params;
    Ticket t;
    public Car( String[] params ){
        this.params = params;
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
    public long begin() {
        return Long.parseLong(params[1]);
    }

    @Override
    public long end() {
        return 0;
    }

    @Override
    public int duration() {
        return 0;
    }

    @Override
    public int price() {
        return 0;
    }


    @Override
    public String toString(){
        return Arrays.toString( params );
    }
}