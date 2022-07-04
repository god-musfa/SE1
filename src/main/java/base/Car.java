package base;

import multiton.Fahrzeugtyp;
import multiton.FahrzeugtypHelper;
import multiton.Kundentyp;
import multiton.KundentypHelper;

import java.util.Arrays;


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
        return Integer.parseInt(params[0]);
        
    }

    public String getVehicleType(){
        return params[8];
    }

    @Override
    public String getKundentyp() {
        return params[7];
    }
    public String getSpace(){
        return params[6];
    }
    @Override
    public Ticket getTicket() {
        return t;
    }

    private void setMissingParams(){
        params[2] = ""+t.getDuration();
        params[3] = ""+t.getPrice();
    }

    @Override
    public String toString(){
        return Arrays.toString( params );
    }
    public String toStringSeperatedBySlash(){ //Todo: needs Test
        this.setMissingParams();
        StringBuilder sb = new StringBuilder();
        sb.append(params[0]);
        for (int i = 1; i < params.length ; i++){
            sb.append("/"+params[i]);
        }
        return sb.toString();
    }

    public void setParkplatzNumber(int n){ //Todo: needs Test
        this.params[6] = ""+n;
    }
}
