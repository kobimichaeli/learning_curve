package AllTrainCars;
import TrainCargos.cargo_type_list;
import utils.train_logger;

public class passengers_car extends train_car_obj {

    public passengers_car(int input_id) throws Exception {
        this.cargo_type = cargo_type_list.get_type_id("passengar");
        this.id = input_id;
        train_logger.sendToLog("debug",getClass().getSimpleName()+" created with id:"+this.id);
    }

    public passengers_car() throws Exception {
        this.cargo_type = cargo_type_list.get_type_id("passengar");
        train_logger.sendToLog("debug", getClass().getSimpleName()+" created with id:" + this.id);
        System.err.println();
    }
}