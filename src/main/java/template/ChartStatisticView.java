package template;

import base.Car;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import mvc.DailyIncomeController;
import mvc.IControllerInterface;
import mvc.IModelInterface;
import mvc.IObserverInterface;
import template.ChartStatistic;
import template.ChartStatisticController;
import template.StatistikTagesEinnahmen;

public class ChartStatisticView implements IObserverInterface {
    private IControllerInterface pController;
    private IModelInterface pModel;
    private StatisticCarTypes s = new StatisticCarTypes();
    private JsonObject jo = Json.createObjectBuilder().build();
    public ChartStatisticView(IModelInterface model) {
        pModel = model;
        model.registerObserver (this);
        pController = new ChartStatisticController(model, this);
    }

    public void enter(Car c){
        pController.enter(c);
    }

    public double leave(int i,long duration){
        return pController.leave(i,duration);
    }

    public void update() {
        jo = s.createPieStatisticsJSON(pModel.getCarsList());
    }


}
