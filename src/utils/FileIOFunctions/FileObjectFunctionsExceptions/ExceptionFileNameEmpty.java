package utils.FileIOFunctions.FileObjectFunctionsExceptions;

import utils.train_logger;

public class ExceptionFileNameEmpty extends Exception{

    public ExceptionFileNameEmpty() {
        super("File name is empty");
        train_logger.sendToLog("error","File name is empty");
    }
}

