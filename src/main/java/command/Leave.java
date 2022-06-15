package command;

import base.Car;
import base.CarIF;
import base.Parkhaus;

public class Leave extends ICommand{


    public Leave(Parkhaus p, int nr) {
        super(p, nr);
    }


}
