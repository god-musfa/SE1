package de.hbrs.team89.se1_starter_repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parkhaus implements ParkhausIF,IModelInterface{


    Car[] cars = new Car[15];
    List<CarIF> carsList = new ArrayList<>();
    @Override
    public int enter(Car c) {
        for(int i = 0;i!= cars.length;i++){
            if(cars[i] == null){
                cars[i]= c;
                carsList.add(c);
                return i+1;
            }
        }
         return -1;
    }

    @Override
    public boolean leave(int nr) { //ToDo Rueckgabewert noch aendern
        if (cars == null) {
            return false;
        }
        for(int i=0; i!=cars.length;i++){
            if(cars[i]==null){
                continue;
            }
            if ((cars[i].nr() == nr && cars[i] != null)){
                cars[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Ticket> getTicket() {
        return carsList.stream().map(x->x.getTicket()).collect(Collectors.toList());
    }

    public Car[] getCars() {
        return cars;
    }

    @Override
    public void registerObserver(IObserverInterface o) {

    }

    @Override
    public void removeObserver(IObserverInterface o) {

    }

    @Override
    public void notifyObservers() {

    }
}
