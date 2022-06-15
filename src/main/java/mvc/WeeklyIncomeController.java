package mvc;

import base.Car;

public class WeeklyIncomeController implements IControllerInterface{
    private IModelInterface m_model;
    private WeeklyIncomeView m_tableView;
    public WeeklyIncomeController (IModelInterface model,
                                  WeeklyIncomeView tableView)
    {
        m_tableView = tableView;
        m_model = model;
    }


    @Override
    public void enter(Car c) {
        m_model.enter(c);
    }

    @Override
    public void leave(int i) {
        m_model.leave(i);
    }
}