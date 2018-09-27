package AllTrainCars;

import Object_id_container.object_id_container;
import TrainCargos.cargo_type_list;
import TrainExceptions.ExceptionCargoNotFound;
import TrainExceptions.ExceptionFileOpenFail;
import TrainExceptions.ExceptionIndexAlreadyRegistered;
import TrainExceptions.ExceptionNullString;
import utils.train_logger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;


public class Train_car_manager implements Serializable {
    private static Train_car_manager Train_car_manager_instance = null;
    private static train_car_factory car_factory_instance = null;

    private static HashMap<Integer, train_car_obj> train_car_object_container = null;
    private static object_id_container train_car_container = null;
    private static train_car_property_data car_properties = null;
    private static Set<String> car_types = null;

    private Train_car_manager() {
        // Dummy Ctor
    }

    public static Train_car_manager get_Train_car_manager_instance () throws ExceptionFileOpenFail, ExceptionNullString {
        if ( Train_car_manager_instance != null ) {
            train_logger.sendToLog("debug", "A Train_car_manager instance already exists");
        } else {
            Train_car_manager_instance = new Train_car_manager();
            car_factory_instance = train_car_factory.get_train_car_factory_instance();
            train_car_object_container = new HashMap<>();
            train_car_container = new object_id_container();
            car_properties = train_car_property_data.getTrain_car_property_data_instance();
            car_types = car_properties.getCar_types();
            train_logger.sendToLog("debug", "A Train_car_manager instance was created");
        }
        return Train_car_manager_instance;
    }

    public static train_car_obj get_new_car(String car_type) throws ExceptionCargoNotFound, ExceptionNullString, ExceptionIndexAlreadyRegistered {
        if ( car_types.contains(car_type) == false )
            throw new ExceptionCargoNotFound(car_type);
        else {
            train_car_obj temp_car = car_factory_instance.create_car(car_type);
            int temp_car_id =  train_car_container.provide_new_id();
            if (train_car_container.check_if_contains_id(temp_car_id) == true) {
                throw new ExceptionIndexAlreadyRegistered(Integer.toString(temp_car_id));
            }
            train_logger.sendToLog("trace", temp_car_id + " can be added since it was not found in the train car list.");
            train_car_container.add_id_to_id_list(temp_car_id);
            temp_car.setId(temp_car_id);
            train_car_object_container.put(temp_car.getId(), temp_car);
            return temp_car;
        }
    }

    public static boolean remove_car(int car_id_in) {
        if (train_car_container.check_if_contains_id(car_id_in) == true) {
            train_car_container.remove_id(car_id_in);
            train_car_object_container.remove(car_id_in);
            train_logger.sendToLog("trace", "car " + car_id_in + " was removed");
            return true;
        }
        train_logger.sendToLog("trace", "car " + car_id_in + " was not found in the track car listing");
        return false;
    }

    public static void main(String[] args) throws ExceptionCargoNotFound, ExceptionNullString, ExceptionFileOpenFail, ExceptionIndexAlreadyRegistered {
        System.out.println("BEGIN");
        cargo_type_list.get_cargo_type_list_instance();
        Train_car_manager.get_Train_car_manager_instance();

        train_car_obj goods = get_new_car("goods_car");
        goods = get_new_car("goods_car");
        goods = get_new_car("coal_car");
        System.out.println(remove_car(1));
        goods = get_new_car("coal_car");
        Train_car_manager.get_Train_car_manager_instance();
    }
}
