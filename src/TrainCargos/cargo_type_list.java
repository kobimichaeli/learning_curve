 package TrainCargos;

import TrainExceptions.*;
import utils.train_logger;
import utils.ini_handler;
import java.util.Map;
import java.util.Set;


public class cargo_type_list {

    private static cargo_type_list cargo_type_list_instance = null;
    private static Map<String, String> available_types = null;

    private cargo_type_list() {
        /* NOTE: dummy Ctor*/
    }

    public static cargo_type_list get_cargo_type_list_instance() throws ExceptionNullString, ExceptionFileOpenFail {
        if (cargo_type_list_instance == null) {
            train_logger.sendToLog("trace", "Instance of cargo_type_list created");
            cargo_type_list_instance = new cargo_type_list();
            cargo_type_list_instance.setup_type_list("conf/cargo_config.ini");
            train_logger.sendToLog("trace", "Creation of instance of cargo_type_list complete");
        }
        return cargo_type_list_instance;
    }

    public void setup_type_list(String config_file_name) throws ExceptionFileOpenFail, ExceptionNullString {
        ini_handler ini_config = new ini_handler(config_file_name);
        available_types = ini_config.get_section_content("cargo_types");
    }

    public static Set<String> get_available_types() {
        return available_types.keySet();
    }

    public static int get_type_id (String wanted_type) throws ExceptionVarNotSet {
        if (available_types == null)
            throw new ExceptionVarNotSet("cargo_type_list::get_type_id::available_types is not set");
        if ( ! available_types.containsKey(wanted_type) ) {
            train_logger.sendToLog("warn", "non-existing type was requested: " + wanted_type);
            return (-1);
        }
        return Integer.valueOf(available_types.get(wanted_type));
    }

    public static void main(String[] args) throws Exception {
        cargo_type_list cargo = get_cargo_type_list_instance();
        cargo.setup_type_list("conf/cargo_config.ini");
        Set<String> t = cargo.get_available_types();
        System.out.println(get_type_id("goods"));
    }
}
