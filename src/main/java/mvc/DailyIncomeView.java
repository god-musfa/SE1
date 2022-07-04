package mvc;

import base.Car;
import template.StatistikTagesEinnahmen;

public class DailyIncomeView implements IObserverInterface {
    private IControllerInterface pController;
    private IModelInterface pModel;
    private double income = 0;
    private StatistikTagesEinnahmen s = new StatistikTagesEinnahmen();
    public DailyIncomeView(IModelInterface model){
        pModel = model;
        model.registerObserver (this);
        pController = new DailyIncomeController(model, this);
    }
    public void enterCar(Car c){
        pController.enter(c);
    }
    public double leave(int i,long duration){
        return pController.leave(i,duration);
    }
    @Override
    public void update() {
        income = s.statistikErstellen(pModel.getTicket());
    }
    public double getDailyIncome(){
        return income;
    }
}
