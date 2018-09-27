package utils;

import TrainExceptions.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class property_reader {
    private HashMap <String, String> cargo_details = new HashMap<String, String>();
    private String local_path = "\\conf\\"; // TODO: see how local_path can be overloaded / defaulted

    public property_reader (String file_name) throws ExceptionNullString {
        if (file_name.isEmpty()) {
            throw new ExceptionNullString("No file name was provided");
        }
        String current_dir = System.getProperty("user.dir") + local_path;
        Properties property_file = new Properties();
        InputStream input_stream = null;
        try {
            input_stream = new FileInputStream(current_dir + file_name);
            property_file.load(input_stream);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
//            System.err.println("Could not open " + current_dir + file_name);
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
//            System.err.println("Null was provided at property_reader (probably at property_file)");
        }
        Enumeration<Object> property_keys = property_file.keys();
        while (property_keys.hasMoreElements()) {
            String temp_key = property_keys.nextElement().toString();
            cargo_details.put(temp_key.toString(), property_file.getProperty(temp_key));
        }
    }

    public HashMap<String, String> get_property_pair (String needed_key){
        HashMap <String, String> ret_val = new HashMap<String, String>();
        ret_val.put(needed_key, cargo_details.get(needed_key) );
        if ( ret_val.get(needed_key) == null ) {
            ret_val = null;
        }
        return ret_val;
    }

    public HashMap<String, String> getCargo_details() {
        return cargo_details;
    }

    public static void main(String[] args) throws ExceptionNullString {
        property_reader tester = new property_reader("cargo_config.ini");
        HashMap<String, String> ret = tester.get_property_pair("goods");
    }
}
