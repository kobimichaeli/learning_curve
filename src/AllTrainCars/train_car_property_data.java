package AllTrainCars;

import TrainExceptions.ExceptionFileOpenFail;
import TrainExceptions.ExceptionNullString;
import utils.ini_handler;
import utils.train_logger;
import java.util.Map;
import java.util.Set;

public class train_car_property_data {
    private static train_car_property_data train_car_property_data_instance = null;
    private static Map<String, Map<String, String>>  car_type_properties = null;
    private static Set<String> car_types = null;

    private train_car_property_data() {
//        NOTE: Dummy CTOR
    }

    public static train_car_property_data getTrain_car_property_data_instance () throws ExceptionNullString, ExceptionFileOpenFail {
        if (train_car_property_data_instance == null) {
            train_logger.sendToLog("trace", "Instance of train_car_property_data created");
            train_car_property_data_instance = new train_car_property_data();
            train_car_property_data.setup_type_list("conf/car_config.ini");
            train_logger.sendToLog("trace", "Creation of instance of train_car_property_data complete");
        }
        return train_car_property_data_instance;
    }

    public static void setup_type_list(String config_file_name) throws ExceptionFileOpenFail, ExceptionNullString {
        ini_handler ini_config = new ini_handler(config_file_name);
        car_type_properties = ini_config.getIni_content();
        car_types = car_type_properties.keySet();
    }


    public static Map<String, Map<String, String>> getCar_type_properties() {
        return car_type_properties;
    }

    public Set<String> getCar_types () {
        return car_types;
    }

    public static void main(String[] args) throws Exception {
        train_car_property_data data = train_car_property_data.getTrain_car_property_data_instance();
        System.out.println(data.getCar_type_properties() );
        System.out.println(data.getCar_types());
    }

}
