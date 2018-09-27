package tracks;

import TrainExceptions.ExceptionMapBoundries;
import TrainExceptions.ExceptionRailDirection;
import TrainExceptions.ExceptionIdNotIndexed;
import TrainExceptions.ExceptionIndexAlreadyRegistered;
import utils.train_logger;
import grid_coordinates.Coordinate;
import Object_id_container.object_id_container;

import java.util.HashMap;
import java.util.Random;

public class Track_factory {
    private static Track_factory track_factory_instance = null;
    private static HashMap<Integer, rail_track> rail_object_container = null;
    private static object_id_container rail_id_index = null;

    private Track_factory() {
//        Dummy Ctor
    }

    public static Track_factory get_track_factory_instance () {
        if ( track_factory_instance != null) {
            train_logger.sendToLog("debug", "A Track_factory instance already exists");
            return track_factory_instance;
        }
        else {
            rail_object_container = new HashMap<>();
            track_factory_instance = new Track_factory();
            rail_id_index = new object_id_container();
            train_logger.sendToLog("debug", "A Track_factory instance was created");
            return track_factory_instance;
        }
    }

    private static rail_track dispense_track(Coordinate coordinate_in, int direction_in) throws ExceptionRailDirection {
        rail_track new_track = new rail_track (coordinate_in, direction_in);
        int new_id = rail_id_index.provide_new_id();
        new_track.setId(new_id);
        return new_track;
    }

    private static boolean register_track(rail_track track_obj) throws ExceptionIndexAlreadyRegistered {
        if ( rail_id_index.check_if_contains_id(track_obj.getId() ))
            throw new ExceptionIndexAlreadyRegistered(Integer.toString(track_obj.getId()));
        rail_id_index.add_id_to_id_list(track_obj.getId());
        rail_object_container.put(track_obj.getId(), track_obj);
        return true;
    }

    public static boolean create_new_track(Coordinate coordinate_in, int direction_in) throws ExceptionRailDirection, ExceptionIndexAlreadyRegistered {
        rail_track temp_track = dispense_track(coordinate_in, direction_in);
        System.out.println(temp_track);
        register_track(temp_track);
        return true;
    }

    public static void delete_track (int del_id) throws ExceptionIdNotIndexed{
        if (rail_id_index.check_if_contains_id(del_id)) {
            rail_object_container.remove(del_id);
            rail_id_index.remove_id(del_id);
        } else throw new ExceptionIdNotIndexed(Integer.toString(del_id));
    }


    //TODO: make this class more robust (might needs refactoring on the allocation handling)
    public static void main (String[] args) throws ExceptionMapBoundries, ExceptionRailDirection, ExceptionIndexAlreadyRegistered {
        Track_factory track = get_track_factory_instance();
        for (int i=0; i <= 5; i++) {
            Random randomGenerator = new Random();
            Coordinate c = new Coordinate(randomGenerator.nextInt(100), randomGenerator.nextInt(100), randomGenerator.nextInt(100));
            Track_factory.create_new_track(c, randomGenerator.nextInt(4));
        }
        System.out.println(rail_object_container);
        try {
            Track_factory.delete_track(4);
            Track_factory.delete_track(5);
        } catch (ExceptionIdNotIndexed exceptionIdNotIndexed) {
            exceptionIdNotIndexed.printStackTrace();
        }
        System.out.println(rail_object_container);
        rail_id_index.print_current_status();
    }
}
