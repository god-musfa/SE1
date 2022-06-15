package command;

import base.Car;
import base.CarIF;
import base.Parkhaus;

public class Enter extends ICommand {

    public Enter(Parkhaus p, CarIF c) {
        super(p, c);
    }

    public void undo() {

    }


}
