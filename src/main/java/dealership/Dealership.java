package dealership;

import behaviours.IBuy;
import customer.Customer;
import vehicles.Car;
import vehicles.VehicleTypes;
import vehicles.parts.Engine;
import vehicles.parts.Tyres;

import java.util.ArrayList;

public class Dealership implements IBuy {
    private String name;
    private int till;
    private ArrayList<Car> stock;
    public Dealership(String name, int till){
        this.name = name;
        this.till = till;
        this.stock = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTill() {
        return till;
    }

    public ArrayList<Car> getStock() {
        return stock;
    }
    public void addCar(Car car){
        this.stock.add(car);
    }

    public void addToTill(int money) {
        this.till += money;
    }

    @Override
    public String buy(Car car) {
        if(this.till>car.getPrice()){
            addToTill(-car.getPrice());
            addCar(car);
            return String.format("The dealership has purchased a %s %s", car.getMake(),  car.getModel());
        }
        else{
            return String.format("The dealership has insufficient funds to purchase the %s %s", car.getMake(), car.getModel());
        }
    }
    public String sellCarToCustomer(Customer customer, String model){
        Car carToSell = findCarInStock(model);
        if(carToSell.getModel() != "Test" && customer.hasMoneyForPurchase(carToSell)){
            customer.buy(carToSell);
            addToTill(carToSell.getPrice());
            this.stock.remove(carToSell);
            return "Enjoy your new car";
        }
        else{
            return "I'm sorry. We don't have that model in stock";
        }
    }
    public Car findCarInStock(String model){
        Car carToReturn = new Car(VehicleTypes.PETROL, "Test", "Test", new Engine("Test", 0, 0), new Tyres("Test", "Test"), "Test", 0);
        for(Car car : this.stock) {
            if (car.getModel() == model) {
                carToReturn = car;
            }
        }
        return carToReturn;
    }
    public void repairDamageToCar(Car car, Customer customer){
        int cost = car.getDamage();
        car.repairDamage();
        charge(customer, cost);
    }

    private void charge(Customer customer, int cost) {
        customer.pay(cost);
        addToTill(cost);
    }
}
