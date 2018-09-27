package TrainExceptions;

public class ExceptionVarNotSet extends Exception{

    public ExceptionVarNotSet(String in) {
        super(in + " is not set");
    }

    public ExceptionVarNotSet() {
        super();
    }
}
