package TrainExceptions;

import utils.train_logger;

public class ExceptionRailDirection extends Exception{

    public ExceptionRailDirection(String str_input) {
        super(str_input);
        train_logger.sendToLog("fatal", str_input, true);

    }

    public ExceptionRailDirection() {
        super();
    }
}

