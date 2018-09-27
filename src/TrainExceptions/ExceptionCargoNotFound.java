package TrainExceptions;

public class ExceptionCargoNotFound extends Exception{

    public ExceptionCargoNotFound(String in) {
        super("Cargo not found: " + in);
    }

    public ExceptionCargoNotFound() {
        super();
    }
}

