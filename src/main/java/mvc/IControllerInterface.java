package mvc;

import base.Car;

public interface IControllerInterface {
    public void enter(Car c);
    public void leave (int i, long duration);

}
