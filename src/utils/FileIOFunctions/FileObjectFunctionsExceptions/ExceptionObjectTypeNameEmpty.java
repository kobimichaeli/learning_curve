package utils.FileIOFunctions.FileObjectFunctionsExceptions;

import utils.train_logger;

public class ExceptionObjectTypeNameEmpty extends Exception{

    public ExceptionObjectTypeNameEmpty() {
        super("object_type_name is empty");
        train_logger.sendToLog("error","object_type_name is empty");
    }
}

