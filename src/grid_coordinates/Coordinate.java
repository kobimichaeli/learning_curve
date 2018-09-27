package grid_coordinates;

import TrainExceptions.ExceptionMapBoundries;
import utils.train_logger;

public class Coordinate {
    int grid_id = -1;
    int Xcoord = -1;
    int Ycoord = -1;

    public Coordinate(int grid_in, int X_in, int Y_in) throws ExceptionMapBoundries{
        if (grid_in < 0 || X_in < 0 || Y_in < 0) {
            throw new ExceptionMapBoundries("Values requested for coordinates are illegal: grid: ("+grid_in + ") X:("+X_in + ") Y:(" + Y_in + ')');
        }
        grid_id = grid_in;
        Xcoord = X_in;
        Ycoord = Y_in;
        train_logger.sendToLog("trace", "created new Coordinate: grid: ("+grid_in + ") X:("+X_in + ") Y:(" + Y_in + ')');
    }

    public int getGrid_id() {
        return grid_id;
    }

    public int getXcoord() {
        return Xcoord;
    }

    public int getYcoord() {
        return Ycoord;
    }

    public static void main(String[] args) throws ExceptionMapBoundries {
        Coordinate c = new Coordinate(1,2,4);
    }
}
