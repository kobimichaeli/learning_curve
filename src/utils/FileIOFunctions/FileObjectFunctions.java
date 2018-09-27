package utils.FileIOFunctions;


import utils.FileIOFunctions.FileObjectFunctionsExceptions.ExceptionFileNameEmpty;
import utils.train_logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;

public class FileObjectFunctions {
    private String filename = null;
    private boolean is_flushed = false;
    private boolean is_open = false;


    public FileObjectFunctions(String file_name_input) throws ExceptionFileNameEmpty {
        if ( file_name_input.isEmpty())
            throw new ExceptionFileNameEmpty();
        filename = file_name_input;
    }

    public Object ReturnFileContent() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            is_open = true;
        } catch (FileNotFoundException ex)  {
            train_logger.sendToLog("fatal", filename + " was not found");
            return null;
        } catch (IOException ex) {
            train_logger.sendToLog("fatal", "Could not open " + filename);
            return null;
        }

        Object read_obj = null;
        try {
            read_obj = objectInputStream.readObject();
            objectInputStream.close();
            is_open = false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return read_obj;
    }

    public static void main (String[] args) throws IOException, ExceptionFileNameEmpty {
        System.out.println("MAIN");
        String file_name = "C:\\Private\\learning_curve\\tmp\\io_test.data";
        HashSet<Double> read_test = new HashSet<>();
        FileObjectFunctions func = new FileObjectFunctions(file_name);
        read_test = (HashSet<Double>)func.ReturnFileContent();
        System.out.println(read_test);
    }
}

//TODO: File manager logger (who is open etc) (as a singleton)
//TODO: multiple object reading