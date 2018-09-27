package AllTrainCars;//import AllTrainCars.train_car_obj;
import TrainCargos.cargo_type_list;
import utils.train_logger;

public class coal_car extends train_car_obj {

    public coal_car(int input_id) throws Exception {
        this.cargo_type = cargo_type_list.get_type_id("coal");
        this.id = input_id;
        train_logger.sendToLog("debug",getClass().getSimpleName()+" created with id:" + this.id);
    }

    public coal_car() throws Exception {
        this.cargo_type = cargo_type_list.get_type_id("coal");
        train_logger.sendToLog("debug", getClass().getSimpleName()+" created with id:" + this.id);
        System.err.println();
    }
}