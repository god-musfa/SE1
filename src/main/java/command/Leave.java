package command;

import base.Car;
import base.CarIF;
import base.Parkhaus;

public class Leave extends ICommand{


    public Leave(Parkhaus p, CarIF c) {
        super(p, c);
    }


}