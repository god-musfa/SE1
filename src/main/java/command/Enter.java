package command;

import base.CarIF;
import base.Parkhaus;

public class Enter extends ICommand {

    public Enter(Parkhaus p, CarIF c) {
        super(p, c);
    }

    @Override
    public void undo() {

    }


}
