package template;

import base.Car;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import mvc.IControllerInterface;
import mvc.IModelInterface;
import mvc.IObserverInterface;

public class ChartStatisticsCarTypesView implements IObserverInterface {
    private IControllerInterface pController;
    private IModelInterface pModel;
    private StatisticCarTypes s = new StatisticCarTypes();
    private JsonObject jo = Json.createObjectBuilder().build();

    public ChartStatisticsCarTypesView(IModelInterface model) {
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

    public JsonObject getPieChart() {
        return jo;
    }
}
