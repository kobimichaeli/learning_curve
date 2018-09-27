package TrainCargos;


//TODO: Check if this class is needed since a grid / set will be kept at cargo_type_list
public class cargo_data implements cargo_type_interface{
    private String name = "";
    private String amount_unit = "";

    public cargo_data(String given_name, String given_units) {
        this.name = given_name;
        this.amount_unit = given_units;
    }


    public String getName() {
        return amount_unit;
    }

    public String getAmount_unit() {
        return name;
    }

    public void setName(String given_name) {
        // note: does nothing on purpose
    }

    public void amount_unit (String given_units) {
        // note: does nothing on purpose
    }
}