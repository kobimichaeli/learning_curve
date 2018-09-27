package Object_id_container;

import utils.train_logger;
import java.util.*;

public class object_id_container {
    private Vector <Integer> id_list = null;
    private Stack <Integer> free_id_stack = null;
    private int max_id;
    private int id_list_counter = -1;


    public object_id_container () {
        id_list = new Vector<Integer>();
        free_id_stack = new Stack<>();
        max_id = -1;
        id_list_counter = 0;
    }

    public boolean add_id_to_id_list(int id_insert) {
        if (free_id_stack.size() == 0) {
            id_list.add(id_list_counter, id_insert);
            train_logger.sendToLog("trace", id_insert + " inserted to list");
        } else {
            free_id_stack.pop();
            id_list.add(id_insert);
            id_list.sort(Comparator.<Integer>naturalOrder());
        }
        id_list_counter++;
        train_logger.sendToLog("trace", "Inserted: " + id_insert);
        if (id_insert > max_id) {
            max_id = id_insert;
            train_logger.sendToLog("trace", "Max is now: " + max_id);
        }
        return true;
    }

    public int provide_new_id () {
        int id_candidate;

        if (free_id_stack.size() > 0) {
            id_candidate = free_id_stack.peek();
            train_logger.sendToLog("trace", "Found " + id_candidate + " in stack");
        } else {
            id_candidate = max_id + 1;
            train_logger.sendToLog("trace", "Not found in stack. Returning" + id_candidate);
        }
        return id_candidate;
    }

    public void fill_up_list () {
//        Random randomGenerator = new Random();
        int loops = 10;
        int range = 50;
        int array[] = new int[] {0, 17, 19, 4,74, 5, 7, 8, 11, 30};
        for (int i=0; i< loops; i++) {
            if (max_id < array[i])
                max_id = array[i];
            id_list.add(array[i]);
            id_list.sort(Comparator.<Integer>naturalOrder());
            id_list_counter++;
        }
        System.out.println("Filling up: "+id_list + " Max: "+  max_id);
    }

    public boolean remove_id (int id_input) {
        if (id_list.contains(id_input)) {
            id_list.remove(id_list.lastIndexOf(id_input));
            id_list_counter--;
            free_id_stack.add(id_input);
            if (id_list_counter > 0)
                max_id = id_list.lastElement();
            else max_id = -1;
            return false;
        }
        return true;
    }

    public void print_current_status() {
        System.out.println("List: " + id_list +'[' + id_list_counter + ']');
        System.out.println("Stack: " + free_id_stack + '[' + free_id_stack.size() + ']');
        System.out.println("Max: " + max_id);
    }

    public boolean check_if_contains_id (int check_id) {
        if (id_list.contains(check_id) == true) {
            train_logger.sendToLog("debug", "id " + check_id + " was found in list.");
            return true;
        }
        return false;
    }

    public int getMax_id () {
        return max_id;
    }

    public static void main (String[] args) {
        object_id_container id = new object_id_container();
        id.print_current_status();
        id.add_id_to_id_list(100);
        id.add_id_to_id_list(20);
        id.add_id_to_id_list(200);
        id.remove_id(200);
        id.remove_id(20);
        id.remove_id(100);
        System.out.println("-------------------------------------------");
        id.print_current_status();

        id.add_id_to_id_list(id.provide_new_id());
        id.add_id_to_id_list(id.provide_new_id());
        id.add_id_to_id_list(id.provide_new_id());

        System.out.println("-------------------------------------------");
        id.print_current_status();

    }
}
