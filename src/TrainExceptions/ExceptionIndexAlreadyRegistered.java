package TrainExceptions;

public class ExceptionIndexAlreadyRegistered extends Exception{

    public ExceptionIndexAlreadyRegistered(String in) {
        super(in + " already exists in the list");
    }

    public ExceptionIndexAlreadyRegistered() {
        super();
    }
}
