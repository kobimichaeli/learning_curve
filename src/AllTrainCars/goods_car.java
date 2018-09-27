package AllTrainCars;//import AllTrainCars.train_car_obj;
import TrainCargos.cargo_type_list;
import utils.train_logger;

public class goods_car extends train_car_obj {

    public goods_car(int input_id) throws Exception {
        this.cargo_type = cargo_type_list.get_type_id("goods");
        this.id = input_id;
        train_logger.sendToLog("debug",getClass().getSimpleName()+" created with id:"+this.id);
    }

    public goods_car() throws Exception {
        this.cargo_type = cargo_type_list.get_type_id("goods");
        train_logger.sendToLog("debug", getClass().getSimpleName()+" created with id:" + this.id);
        System.err.println();
    }
}