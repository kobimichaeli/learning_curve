package tests;

//import org.ini4j.*;
//
import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class ini_test {
    String ini_file_name = null;
    Ini ini = null;
    Set<String> sections = null;

    public ini_test () throws IOException {
        this.ini = new Ini(new File("conf/cargo_config.ini"));
        System.out.println("Number of sections: "+ini.size()+"\n");

        sections = ini.keySet();
    }

    public void print(Object str) {
        System.out.println(str);
    }

    public Set<String> read_sections_names() {
        return this.sections;
    }

//    public List<Profile.Section> getSectionContent (String section_name) {
    public void getSectionContent (String section_name) {
        Set<Map.Entry<String, Profile.Section>> sections = ini.entrySet(); /* !!! */

        for (Map.Entry<String, Profile.Section> entry : sections) {
            Profile.Section section = entry.getValue();
            Set<Map.Entry<String, String>> values = section.entrySet();

            for (Map.Entry<String,String> section_entry : values  ) {
                print (section_entry.getKey() + "  -  " + section_entry.getValue());
            }
        }


//
//        for (Map.Entry<String, Profile.Section> e : sections) {
//            Profile.Section section = e.getValue();
//            System.out.println("[" + section.getName() + "]");
//            Set<Map.Entry<String, String>> values = section.entrySet();
//
//            for (Map.Entry<String, String> e2 : values) {
//                System.out.println(e2.getKey() + " = " + e2.getValue());
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, Map<String, String>> ini_content = new HashMap<String, Map<String, String>>();

        HashMap<String, String> section = new HashMap<>();
        section.put("units" , "passengers");
        section.put("max" , "80");

        ini_content.put("TEST", section);

        System.out.println("----->"+ini_content.get("TEST").get("units"));

    }
}



















