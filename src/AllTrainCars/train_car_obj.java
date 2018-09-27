package AllTrainCars;


public abstract class train_car_obj implements train_car_interface {
    int id = -1;
    int type = -1; // TODO: is this needed? what's it for?
    int weight = -1;
    int value = -1;
    int cargo_type = -1;
    int cargo_amount = -1;

    public int getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }
    
    public int getWeight(){
        return this.weight;
    }

    public int getValue(){
        return this.value;
    }

    public int getCargo_type(){
        return this.cargo_type;
    }

    public int getCargo_amount(){
        return this.cargo_amount;
    }


    public void setId(int input_id) {
        id = input_id;
    }

    public void setType(int input_type) {
        type = input_type;
    }

    public void  setWeight(int input_weight) {
        weight = input_weight;
    }

    public void  setValue(int input_value) {
        value = input_value;
    }

    public void  setCargo_type(int input_cargo_type) {
        cargo_type = input_cargo_type;
    }

    public void  setCargo_amount(int input_cargo_amount) {
        cargo_amount = input_cargo_amount;
    }

    @Override
    public String toString() {
        return ("[ID: " + id + " Cargo type id: " + cargo_type  + " Type id: " + type + " Weight: " + weight + " Value: " + value + " Cargo amount: " + cargo_amount + ']');
    }
}
