package base;

import command.Enter;
import command.ICommand;
import command.Leave;
import mvc.IModelInterface;
import mvc.IObserverInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parkhaus implements ParkhausIF, IModelInterface {

    private ArrayList<IObserverInterface> mobservers = new ArrayList<IObserverInterface>();

    private ArrayList<ICommand> clist = new ArrayList<>();
    private ArrayList<Enter> elist = new ArrayList<>();


    Car[] cars;
    List<CarIF> carsList = new ArrayList<>();

    public Parkhaus(int size){
        cars = new Car[size];
    }
    @Override
    public int enter(Car c) {
        for(int i = 0;i!= cars.length;i++){
            if(cars[i] == null){
                cars[i]= c;
                carsList.add(c);

                Enter e = new Enter(this,c);
                clist.add(e);
                elist.add(e);

                this.notifyObservers();
                return i+1;
            }
        }
        this.notifyObservers();
         return -1;
    }

    @Override
    public boolean leave(int nr) { //ToDo Rueckgabewert noch aendern
        if (cars == null) {
            this.notifyObservers();
            return false;
        }
        for(int i=0; i!=cars.length;i++){
            if(cars[i]==null){
                continue;
            }
            if ((cars[i].nr() == nr && cars[i] != null)){
                cars[i] = null;
                Leave l = new Leave(this,nr);
                clist.add(l);
                Optional<Enter> o = elist.stream().filter(x->(x.getCar().nr()==nr)).findFirst();
                if(o.isPresent()) {
                    elist.remove(o.get());
                }
                this.notifyObservers();
                return true;
            }
        }
        this.notifyObservers();
        return false;
    }

    @Override
    public List<TicketIF> getTicket() {
        return carsList.stream().map(CarIF::getTicket).collect(Collectors.toList());
    }

    @Override
    public ArrayList<ICommand> getCommand() {
        return clist;
    }

    @Override
    public ArrayList<Enter> getEnterCommand() {
        return elist;
    }

    public Car[] getCars() {
        return cars;
    }

    @Override
    public void registerObserver(IObserverInterface o) {
        mobservers.add (o);
    }

    @Override
    public void removeObserver(IObserverInterface o) {
        if (mobservers.contains (o))
            mobservers.remove (o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < mobservers.size(); ++i)
            mobservers.get (i).update();

    }
    public void undo(){
        if (!elist.isEmpty()) elist.remove(elist.size()-1).undo();
    }
    public int getParkplatzSize(){
        return cars.length;
    }
    public void changeMax(int newSize){ //ToDo size groesser machen error
        Car[] temp = cars;
        Car[] newCars = new Car[newSize];
        for (int i = 0; i < newCars.length ; i++){
            newCars[i] = cars[i];
        }
        cars = newCars;
    }
}
