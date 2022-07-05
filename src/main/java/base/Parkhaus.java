package base;

import command.Enter;
import command.ICommand;
import command.Leave;
import multiton.FahrzeugtypHelper;
import multiton.KundentypHelper;
import mvc.IModelInterface;
import mvc.IObserverInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parkhaus implements ParkhausIF, IModelInterface {

    private ArrayList<IObserverInterface> mobservers = new ArrayList<>();

    private ArrayList<ICommand> clist = new ArrayList<>();
    private ArrayList<Enter> elist = new ArrayList<>();


    CarIF[] cars;
    List<CarIF> carsList = new ArrayList<>();

    public Parkhaus(int size){
        cars = new Car[size];
    }
    @Override
    public int enter(CarIF c) {
        for(int i = 0;i!= cars.length;i++){
            if(cars[i] == null){
                cars[i]= c;
                carsList.add(c);

                Enter e = new Enter(this,c);
                clist.add(e);
                elist.add(e);
                c.setParkplatzNumber(i+1);

                this.notifyObservers();
                return i+1;
            }
        }
        this.notifyObservers();
         return -1;
    }

    @Override
    public double leave(int nr, long duration) {
        for(int i=0; i!=cars.length;i++){
            if(cars[i]==null){
                continue;
            }
            if (cars[i].getNr() == nr){
                CarIF car = cars[i];
                car.getTicket().setPrice(FahrzeugtypHelper.getFahrzeug(car.getVehicleType()), KundentypHelper.getKunde(car.getKundentyp()),duration);
                double price = car.getTicket().getPrice();
                cars[i] = null;
                Leave l = new Leave(this,nr);
                clist.add(l);
                Optional<Enter> o = elist.stream().filter(x->(x.getCar().getNr()==nr)).findFirst();
                if(o.isPresent()) {
                    elist.remove(o.get());
                }
                this.notifyObservers();
                return price;
            }
        }
        this.notifyObservers();
        return -1.00;
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

    @Override
    public List<CarIF> getCarsList() {
        return carsList;
    }

    public CarIF[] getCars() {
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

    public List<IObserverInterface> getObservers(){
        return mobservers;
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
    public void changeMax(int newSize){
        CarIF[] newCars;
        newCars = changeArraySize(newSize);
        cars = newCars;
    }

    private CarIF[] changeArraySize(int newSize){
        CarIF[] newCars = new Car[newSize];
        int forLoopSize;

        if (newSize > this.cars.length){
            forLoopSize = this.cars.length;
        }else{
            forLoopSize = newSize;
        }

        for (int i = 0; i < forLoopSize ; i++){
            newCars[i] = this.cars[i];
        }
        return newCars;
    }
    public String carsListToString() {
        if (!this.getCarsList().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getCarsList().get(0).toStringSeperatedBySlash());
            for (int i = 1; i < this.getCarsList().size(); i++) {
                sb.append("," + this.getCarsList().get(i).toStringSeperatedBySlash());
            }
            return sb.toString();
        }
        else {
            return "";
        }
    }
    public void reset(){
        this.getCarsList().clear();
        this.cars = new CarIF[cars.length];
    }
}
