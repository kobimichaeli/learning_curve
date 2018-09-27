package AllTrainCars;

/**
 * Created by kobi.michaeli on 10/1/2016.
 */
public interface train_car_interface {
    int id = 0;
    int type = 0;
    int weight = 0;;
    int value = 0;;
    int cargo_type = 0;;
    int cargo_amount = 0;

    int getId();
    int getType();
    int getWeight();
    int getValue();
    int getCargo_type();
    int getCargo_amount();

    void setId(int input_id);
    void setType(int input_type);
    void setWeight(int input_weight);
    void setValue(int input_value);
    void setCargo_type(int input_cargo_type);
    void setCargo_amount(int input_cargo_amount);
}
