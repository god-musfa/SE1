package base;

import helper.ParamsHelper;
import multiton.Fahrzeugtyp;
import multiton.FahrzeugtypHelper;


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
    public int getNr() {
        return Integer.parseInt(ParamsHelper.getNr(this.params));
    }
    public Long getTimer(){
        return Long.parseLong(ParamsHelper.getTimer(this.params));
    }
    public String getColor(){
        return ParamsHelper.getColor(this.params);
    }


    public String getVehicleType(){
        return ParamsHelper.getVehicle_type(this.params);
    }

    @Override
    public String getKundentyp() {
        return ParamsHelper.getClient_category(this.params);
    }
    public int getSpace(){
        return Integer.parseInt(ParamsHelper.getSpace(this.params));
    }
    public String getLicense(){
        return ParamsHelper.getLicense(this.params);
    }

    @Override
    public Ticket getTicket() {
        return t;
    }

    private void setMissingParams(){
        params[2] = ""+t.getDuration();
        params[3] = ""+t.getPrice();
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
