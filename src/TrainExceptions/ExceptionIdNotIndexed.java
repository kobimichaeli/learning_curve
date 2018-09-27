package TrainExceptions;

public class ExceptionIdNotIndexed extends Exception{

    public ExceptionIdNotIndexed(String in) {
        super(in + " was not found in object index");
    }

    public ExceptionIdNotIndexed() {
        super();
    }
}
