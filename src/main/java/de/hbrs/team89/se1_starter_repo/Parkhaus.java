package de.hbrs.team89.se1_starter_repo;

public class Parkhaus implements ParkhausIF{


    Car[] cars = new Car[15];
    @Override
    public int enter(Car c) {
        for(int i = 0;i!= cars.length;i++){
            if(cars[i] == null){
                cars[i]= c;
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
    public Car[] getCars() {
        return cars;
    }

}