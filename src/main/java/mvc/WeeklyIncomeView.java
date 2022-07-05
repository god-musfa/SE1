package mvc;

import base.Car;
import template.StatistikTagesEinnahmen;
import template.StatistikWochenEinnahmen;

public class WeeklyIncomeView implements IObserverInterface {
    private IControllerInterface pController;
    private IModelInterface pModel;
    private double income = 0;
    private StatistikWochenEinnahmen s = new StatistikWochenEinnahmen();
    public WeeklyIncomeView(IModelInterface model){
        pModel = model;
        model.registerObserver (this);
        pController = new WeeklyIncomeController(model, this);
    }

    public void enterCar(Car c){
        pController.enter(c);
    }
    public double leave(int i,long duration){
        return pController.leave(i,duration);
    }
    @Override
    public void update() {
        income = s.statistikErstellen(pModel.getTicket())/100;
    }
    public double getWeeklyIncome(){
        return income;
    }
}
