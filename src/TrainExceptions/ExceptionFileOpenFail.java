package TrainExceptions;

import utils.train_logger;

public class ExceptionFileOpenFail extends Exception{

    public ExceptionFileOpenFail() {
        super();
    }

    public ExceptionFileOpenFail(String str_input) {
        super(str_input);
        train_logger.sendToLog("fatal", str_input, true);
    }
}

