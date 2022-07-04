package mvc;

import base.Car;

public class WeeklyIncomeController implements IControllerInterface{
    private IModelInterface mModel;
    private WeeklyIncomeView mTableView;
    public WeeklyIncomeController (IModelInterface model,
                                  WeeklyIncomeView tableView)
    {
        mTableView = tableView;
        mModel = model;
    }


    @Override
    public void enter(Car c) {
        mModel.enter(c);
    }

    @Override
    public double leave(int i,long duration) {
        return mModel.leave(i,duration);
    }
}