package de.hbrs.team89.se1_starter_repo;

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
    }

    @Override
    public void leave(int i) {
    }
}