import TrainCargos.cargo_type_list;
import AllTrainCars.*;
import TrainExceptions.ExceptionFileOpenFail;
import TrainExceptions.ExceptionNullString;
import tracks.Track_factory;
import utils.train_logger;

public class Main {
    static cargo_type_list cargo_type_list_var = null;
    static train_car_property_data car_type_properties_var = null;
    static train_car_factory train_car_factory_var = null;
    static Track_factory track_factory_var = null;

    private static void bootstrap() throws ExceptionNullString, ExceptionFileOpenFail {
        train_logger.sendToLog("info","bootstrap begins-----------------------------------", true);
        cargo_type_list_var = cargo_type_list.get_cargo_type_list_instance();
        car_type_properties_var = train_car_property_data.getTrain_car_property_data_instance();
        train_car_factory_var = train_car_factory.get_train_car_factory_instance();
        track_factory_var = Track_factory.get_track_factory_instance();
        train_logger.sendToLog("info","bootstrap finished", true);
    }

    private static void endprogram() {
        train_logger.sendToLog("info","All done-------------------------------------------", true);
    }

    public static void main(String[] args) throws Exception{
        bootstrap();
        for (String car : car_type_properties_var.getCar_types() ) {
            train_car_factory_var.create_car(car);
        }
        endprogram();
    }
}
//TODO: create a frame for writing data to the disk