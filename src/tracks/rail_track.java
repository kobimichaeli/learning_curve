package tracks;

import TrainExceptions.ExceptionMapBoundries;
import TrainExceptions.ExceptionRailDirection;
import grid_coordinates.Coordinate;
import utils.train_logger;

public class rail_track {
    private int id = -1;
    private int direction = -1;
//    private int cycle_stamp = -1;
    private Coordinate location = null;
    
    public rail_track (Coordinate coordinate_in, int direction_in) throws ExceptionRailDirection {
        if (direction_in < 0 || direction_in > 3) {
            throw new ExceptionRailDirection("Wrong rail direction provided:" + direction_in);
        }
        id = -1;
//        cycle_stamp = 0; TODO: when there's time, this should be added
        direction = direction_in;
        location = coordinate_in;
        train_logger.sendToLog("trace", "Rail object created with id [" + id + ']');
    }

    public void setId (int id_in) {
        id = id_in;
    }

    public int getId () {
        return id;
    }

    public String toString() {
        return ("ID: " + id + " X: " + location.getXcoord() + " Y:" + location.getYcoord() + " location: " + location.getGrid_id());
    }

    public static void main(String[] args) throws ExceptionRailDirection, ExceptionMapBoundries {
        rail_track r = new rail_track (new Coordinate(1,2,3),1);
    }
}
