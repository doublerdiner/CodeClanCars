package customer;

import behaviours.IBuy;
import vehicles.Car;

import java.util.ArrayList;

public class Customer implements IBuy {
    private String name;
    private int money;
    private ArrayList<Car> vehicles;
    public Customer(String name, int money){
        this.name = name;
        this.money = money;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Car> getVehicles() {
        return vehicles;
    }

    public void addCar(Car car) {
        this.vehicles.add(car);
    }

    @Override
    public String buy(Car car) {
        if(hasMoneyForPurchase(car)){
            pay(car.getPrice());
            addCar(car);
            return String.format("%s %s has been purchased", car.getMake(),  car.getModel());
        }
        else{
            return String.format("Insufficient funds to purchase %s %s", car.getMake(), car.getModel());
        }

    }

    public boolean hasMoneyForPurchase(Car car) {
        return this.money > car.getPrice();
    }

    public void pay(int cost) {
        this.money -= cost;
    }
}
