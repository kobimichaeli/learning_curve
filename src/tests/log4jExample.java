package tests;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;

public class log4jExample{

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(log4jExample.class.getName());

    public static Logger getLoggerHandle(){
        return log;
    }

    public static void main(String[] args)throws IOException,SQLException{
//        ClassLoader loader = Test.class.getClassLoader();
//        System.out.println(loader.getResource(""));

        log.debug("Hello this is a debug message");
        log.error("Hello this is an info message");
    }
}