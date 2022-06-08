package de.hbrs.team89.se1_starter_repo;

public class DailyIncomeController implements IControllerInterface{
    private IModelInterface m_model;
    private DailyIncomeView m_tableView;
    public DailyIncomeController (IModelInterface model,
                                DailyIncomeView tableView)
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
