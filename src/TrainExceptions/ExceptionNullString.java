package TrainExceptions;

public class ExceptionNullString extends Exception{

    public ExceptionNullString(String in) {
        super("NULL string " + in);
    }

    public ExceptionNullString() {
        super();
    }
}
