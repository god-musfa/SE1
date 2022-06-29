package command;

import base.Car;
import base.CarIF;
import base.Parkhaus;

import java.util.Optional;


public class Enter extends ICommand {

    public Enter(Parkhaus p, CarIF c) {
        super(p, c);
    }

    public void undo() {
        Optional<ICommand> o = ph.getCommand().stream().filter(x->x.getCar().equals(c)).findFirst();
        if(o.isPresent()) {
            ph.getCommand().remove(o.get());
            for(int i = 0; i!=ph.getCars().length;i++){
                if(c.equals(ph.getCars()[i])) ph.getCars()[i] = null;
            }
        }


    }


}
