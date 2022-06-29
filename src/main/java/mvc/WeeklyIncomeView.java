package mvc;

import base.Car;
import template.StatistikTagesEinnahmen;

public class WeeklyIncomeView implements IObserverInterface {
    private IControllerInterface pController;
    private IModelInterface pModel;
    private double income = 0;
    private StatistikTagesEinnahmen s = new StatistikTagesEinnahmen();
    public WeeklyIncomeView(IModelInterface model){
        pModel = model;
        model.registerObserver (this);
        pController = new WeeklyIncomeController(model, this);
    }

    public void enterCar(Car c){
        pController.enter(c);
    }
    public void leave(int i){
        pController.leave(i);
    }
    @Override
    public void update() {
        income = s.statistikErstellen(pModel.getTicket());
    }
    public double getWeeklyIncome(){
        return income;
    }
}
