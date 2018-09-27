package AllTrainCars;
import TrainExceptions.*;
import TrainCargos.*;
import utils.train_logger;


public class train_car_factory {
    private static train_car_factory train_car_manager_instances = null;
    private static train_car_property_data train_properties = null;

    public train_car_factory(){
        // Just a dummy function
    }
    public static train_car_factory get_train_car_factory_instance() throws ExceptionFileOpenFail, ExceptionNullString {
        if (  train_car_manager_instances == null ) {
            train_car_manager_instances = new train_car_factory();
            train_properties = train_car_property_data.getTrain_car_property_data_instance();
            train_logger.sendToLog("debug", "A train_car_factory instance was created");
        } else {
            train_logger.sendToLog("debug", "A train_car_factory instance already exists");
        }
        return train_car_manager_instances;
    }

    public static train_car_obj create_car(String type_tag) throws ExceptionNullString {
        if (type_tag.isEmpty()) {
            throw new ExceptionNullString("No train car type provided");
        }
        train_car_obj produced_car = null;
        Class<?> cls = null;
        try {
            cls = Class.forName("AllTrainCars."+type_tag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            produced_car = (train_car_obj) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return produced_car;
    }

    public static void main(String[] args) throws Exception {
//        cargo_type_list cargo_type_list_var = cargo_type_list.get_cargo_type_list_instance();
//        System.out.println("IN MAIN (AllTrainCars.train_car_factory)");
//        train_car_factory.get_train_car_factory_instance();
        cargo_type_list.get_cargo_type_list_instance();
        train_car_obj c = train_car_factory.create_car("goods_car");
    }
}