package vehicles;

import vehicles.parts.Engine;
import vehicles.parts.Tyres;

public class Car {
    private VehicleTypes vehicleType;
    private String make;
    private String model;
    private Engine engine;
    private Tyres tyres;
    private String colour;
    private int damage;
    private int price;
    public Car(VehicleTypes vehicleType, String make, String model, Engine engine, Tyres tyres, String colour, int price){
        this.vehicleType = vehicleType;
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.tyres = tyres;
        this.colour = colour;
        this.price = price;
        this.damage = 0;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }
    public String getVehicleTypeFormatted(){
        return vehicleType.getFormattedName();
    }
    public boolean doesVehicleHaveBattery(){
        return vehicleType.getHasBattery();
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public Engine getEngine() {
        return engine;
    }
    public Tyres getTyres() {
        return tyres;
    }
    public String getColour() {
        return colour;
    }
    public int getPrice() {
        return price;
    }
    public int getDamage() {return damage;}

    public void increaseDamage(int i) {
        this.damage += i;
        this.price -= i;
    }
    public void repairDamage() {
        this.damage = 0;
    }
}
