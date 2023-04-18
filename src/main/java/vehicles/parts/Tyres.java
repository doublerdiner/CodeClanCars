package vehicles.parts;

public class Tyres {
    private String manufacturer;
    private String model;

    public Tyres(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
}
