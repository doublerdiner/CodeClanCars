import customer.Customer;
import dealership.Dealership;
import org.junit.Before;
import org.junit.Test;
import vehicles.Car;
import vehicles.VehicleTypes;
import vehicles.parts.Engine;
import vehicles.parts.Tyres;

import static org.junit.Assert.assertEquals;

public class DealershipTest {
    private Dealership dealership;
    private Car car;
    private Engine engine;
    private Tyres tyres;
    private Customer customer;
    @Before
    public void setup(){
        engine = new Engine("1.5L TDCi diesel", 95, 111);
        tyres = new Tyres("Kumho", "Ecowing ES31");
        car = new Car(VehicleTypes.DIESEL, "Ford", "Focus", engine, tyres, "Blue", 26040);
        dealership = new Dealership("CodeClan Engines", 150000);
        customer = new Customer("Nick", 50000);
    }
    @Test
    public void dealershipHasName(){
        assertEquals("CodeClan Engines", dealership.getName());
    }
    @Test
    public void dealershipHasTill(){
        assertEquals(150000, dealership.getTill());
    }
    @Test
    public void dealershipHasStock(){
        assertEquals(0, dealership.getStock().size());
    }
    @Test
    public void dealershipCanPurchaseACar(){
        String answer = dealership.buy(car);
        assertEquals(123960, dealership.getTill());
        assertEquals(1, dealership.getStock().size());
        assertEquals("Focus", dealership.getStock().get(0).getModel());
        assertEquals("The dealership has purchased a Ford Focus", answer);
    }
    @Test
    public void dealershipCanSellCarToCustomer(){
        dealership.buy(car);
        String answer = dealership.sellCarToCustomer(customer, "Focus");
        assertEquals(150000, dealership.getTill());
        assertEquals(0, dealership.getStock().size());
        assertEquals("Enjoy your new car", answer);
        assertEquals(1, customer.getVehicles().size());
        assertEquals(23960, customer.getMoney());
    }
    @Test
    public void repairDamageToVehicle(){
        car.increaseDamage(2000);
        dealership.repairDamageToCar(car, customer);
        assertEquals(48000, customer.getMoney());
        assertEquals(152000, dealership.getTill());
        assertEquals(0, car.getDamage());
    }

}
