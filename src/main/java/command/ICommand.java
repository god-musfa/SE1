package command;

import base.Car;
import base.CarIF;
import base.Parkhaus;

public abstract class ICommand {
    Parkhaus ph;
    CarIF c;
    int nr;

    public ICommand (Parkhaus p, CarIF c){
        ph = p;
        this.c = c;
    }

    public ICommand (Parkhaus p, int nr){
        ph = p;
        this.nr = nr;
    }

    public CarIF getCar(){
        return c;
    }
}
