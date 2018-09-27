package utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;

public class train_logger {
//    OFF  FATAL  ERROR  WARN  INFO  DEBUG  TRACE
    static private Logger LOG4J_HANDLE = Logger.getLogger(train_logger.class.getName());


    public static void sendToLog(String level, String logMessage, boolean onscreen) {
        date_time time_string_source = new date_time(true);

        System.out.println('[' + time_string_source.get_date_time() +']'+"["+ level  + "]"+"["+ logMessage + "]");
        sendToLog(level,logMessage);
    }

    public static void sendToLog(String level, String logMessage) {
        switch (level){
            case "fatal":
                LOG4J_HANDLE.fatal(logMessage);
                break;
            case "error":
                LOG4J_HANDLE.error(logMessage);
                break;
            case "warn":
                LOG4J_HANDLE.warn(logMessage);
                break;
            case "info":
                LOG4J_HANDLE.info(logMessage);
                break;
            case "debug":
                LOG4J_HANDLE.debug(logMessage);
                break;
            case "trace":
                LOG4J_HANDLE.trace(logMessage);
                break;
        }
    }

    public static void main(String[] args)throws IOException,SQLException {

        LOG4J_HANDLE.fatal("Hello this is a debug message");
    }
}
