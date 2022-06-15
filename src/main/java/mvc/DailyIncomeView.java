package mvc;

import base.Car;
import template.StatistikTagesEinnahmen;

public class DailyIncomeView implements IObserverInterface {
    private IControllerInterface p_controller;
    private IModelInterface p_model;
    private double income = 0;
    private StatistikTagesEinnahmen s = new StatistikTagesEinnahmen();
    public DailyIncomeView(IModelInterface model){
        p_model = model;
        model.registerObserver (this);
        p_controller = new DailyIncomeController(model, this);
    }
    public void enterCar(Car c){
        p_controller.enter(c);
    }
    public void leave(int i){
        p_controller.leave(i);
    }
    @Override
    public void update() {
        income = s.statistikErstellen(p_model.getTicket());
    }
    public double getDailyIncome(){
        return income;
    }
}
