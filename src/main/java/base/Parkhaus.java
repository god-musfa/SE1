package base;

import command.Enter;
import command.ICommand;
import mvc.IModelInterface;
import mvc.IObserverInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parkhaus implements ParkhausIF, IModelInterface {

    private ArrayList<IObserverInterface> m_observers = new ArrayList<IObserverInterface>();

    private ArrayList<ICommand> clist = new ArrayList<>();
    private ArrayList<Enter> elist = new ArrayList<>();


    Car[] cars = new Car[15];
    List<CarIF> carsList = new ArrayList<>();
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
                this.notifyObservers();
                return true;
            }
        }
        this.notifyObservers();
        return false;
    }

    @Override
    public List<TicketIF> getTicket() {
        return carsList.stream().map(x->x.getTicket()).collect(Collectors.toList());
    }

    @Override
    public ArrayList<ICommand> getCommand() {
        return clist;
    }

    public Car[] getCars() {
        return cars;
    }

    @Override
    public void registerObserver(IObserverInterface o) {
        m_observers.add (o);
    }

    @Override
    public void removeObserver(IObserverInterface o) {
        if (m_observers.contains (o))
            m_observers.remove (o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < m_observers.size(); ++i)
            m_observers.get (i).update();

    }
}