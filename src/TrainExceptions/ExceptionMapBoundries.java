package TrainExceptions;

import utils.train_logger;

public class ExceptionMapBoundries extends Exception{

    public ExceptionMapBoundries(String str_input) {
        super(str_input);
        train_logger.sendToLog("fatal", str_input, true);

    }

    public ExceptionMapBoundries() {
        super();
    }
}

