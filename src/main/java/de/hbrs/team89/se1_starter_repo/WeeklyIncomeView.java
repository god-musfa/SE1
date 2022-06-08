package de.hbrs.team89.se1_starter_repo;

public class WeeklyIncomeView implements IObserverInterface {
    private IControllerInterface p_controller;
    private IModelInterface p_model;

    public WeeklyIncomeView(IModelInterface model){
        p_model = model;
        model.registerObserver (this);
        p_controller = new WeeklyIncomeController(model, this);
    }

    @Override
    public void update() {

    }
}
