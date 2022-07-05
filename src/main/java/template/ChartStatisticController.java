package template;

import base.Car;
import mvc.DailyIncomeView;
import mvc.IControllerInterface;
import mvc.IModelInterface;

public class ChartStatisticController implements IControllerInterface {

    private IModelInterface mModel;
    private ChartStatisticView mTableView;

    public ChartStatisticController (IModelInterface model,
                                     ChartStatisticView tableView)
    {
        mTableView = tableView;
        mModel = model;
    }

    @Override
    public void enter(Car c) {
        mModel.enter(c);
    }

    @Override
    public double leave(int i, long duration) {
        return mModel.leave(i,duration);
    }
}
