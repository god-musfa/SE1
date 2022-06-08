package de.hbrs.team89.se1_starter_repo;
public class DailyIncomeView implements IObserverInterface {
    private IControllerInterface p_controller;
    private IModelInterface p_model;

    public DailyIncomeView(IModelInterface model){
        p_model = model;
        model.registerObserver (this);
        p_controller = new DailyIncomeController(model, this);
    }

    @Override
    public void update() {

    }
}
