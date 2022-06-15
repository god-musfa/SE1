package command;

import base.Car;
import base.CarIF;
import base.Parkhaus;

import java.util.stream.Collectors;

public class Enter extends ICommand {

    public Enter(Parkhaus p, CarIF c) {
        super(p, c);
    }

    public void undo() {
        ph.getCommand().remove(ph.getCommand().stream().filter(x->x.getCar().equals(c)).findFirst().get());
        ph.getEnterCommand().remove(c);
        for(int i = 0; i!=ph.getCars().length;i++){
            if(c.equals(ph.getCars()[i])) ph.getCars()[i] = null;
        }

    }


}
