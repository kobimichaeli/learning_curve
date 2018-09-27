package utils;

import TrainExceptions.*;

import org.ini4j.Ini;
import org.ini4j.Profile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ini_handler {
    private String ini_file_name = null;
    private Set<String> ini_sections = null;
    private HashMap<String, Map<String, String>> ini_content = null;

    public ini_handler (String ini_full_path_name) throws ExceptionNullString,ExceptionFileOpenFail {
        if (ini_full_path_name.isEmpty()) {
            train_logger.sendToLog ("trace", "Empty file name was provided");
            throw new ExceptionNullString();
        }

        ini_file_name = ini_full_path_name;
        try {
            Ini ini = new Ini(new File(ini_file_name));
            parse_ini_file(ini);
        } catch (IOException ex) {
            train_logger.sendToLog ("fatal", "Failed to open "+ ini_file_name);
            throw new ExceptionFileOpenFail();
        }
    }

    private void parse_ini_file (Ini ini_raw_data) {
        ini_sections = ini_raw_data.keySet(); // Just taking the keys for future
        ini_content = new HashMap<String, Map<String, String>>();
        train_logger.sendToLog ("trace", "Begining to parse "+ ini_file_name);
        Set<Map.Entry<String, Profile.Section>> temp_ini_sections = ini_raw_data.entrySet();
        for (Map.Entry<String, Profile.Section> entry : temp_ini_sections) {
            Profile.Section section = entry.getValue();
            Set<Map.Entry<String, String>> values = section.entrySet();
            HashMap<String, String> section_content = new HashMap<>();
            for (Map.Entry<String,String> section_entry : values  ) {
                section_content.put( section_entry.getKey(),section_entry.getValue() );
            }
            ini_content.put(entry.getKey(), section_content);
        }
        train_logger.sendToLog ("trace", "Done parsing "+ ini_file_name);
    }

    public boolean check_for_section(String section_name) {
        if (! ini_sections.contains(section_name))
            return false;
        return true;
    }

    public String getIni_file_name () {
        return ini_file_name;
    }

    public Set<String> getIni_sections (){
        return ini_sections;
    }

    public HashMap<String, Map<String, String>> getIni_content () {
        return ini_content;
    }

    public Map<String,  String> get_section_content(String section_name) {
        if (! check_for_section(section_name))
            return (null);
        return ini_content.get(section_name);
    }

    public static void main(String[] args) throws IOException, ExceptionFileOpenFail, ExceptionNullString {
        ini_handler h = new ini_handler("conf/cargo_config.ini");
        Ini i = new Ini(new File("conf/cargo_config.ini"));
    }


}