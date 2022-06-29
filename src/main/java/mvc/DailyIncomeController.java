package mvc;

import base.Car;

public class DailyIncomeController implements IControllerInterface{
    private IModelInterface mModel;
    private DailyIncomeView mTableView;
    public DailyIncomeController (IModelInterface model,
                                DailyIncomeView tableView)
    {
        mTableView = tableView;
        mModel = model;
    }


    @Override
    public void enter(Car c) {
        mModel.enter(c);
    }

    @Override
    public void leave(int i) {
        mModel.leave(i);
    }
}
