import customer.Customer;
import org.junit.Before;
import org.junit.Test;
import vehicles.Car;
import vehicles.VehicleTypes;
import vehicles.parts.Engine;
import vehicles.parts.Tyres;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;
    private Car car;
    private Engine engine;
    private Tyres tyres;
    @Before
    public void setup(){
        engine = new Engine("1.5L TDCi diesel", 95, 111);
        tyres = new Tyres("Kumho", "Ecowing ES31");
        car = new Car(VehicleTypes.DIESEL, "Ford", "Focus", engine, tyres, "Blue", 26040);
        customer = new Customer("Nick", 50000);
    }
    @Test
    public void customerHasName(){
        assertEquals("Nick", customer.getName());
    }
    @Test
    public void customerHasMoney(){
        assertEquals(50000, customer.getMoney());
    }
    @Test
    public void customerHasVehicles(){
        assertEquals(0, customer.getVehicles().size());
    }
    @Test
    public void customerCanBuyVehicle(){
        String answer = customer.buy(car);
        assertEquals(23960, customer.getMoney());
        assertEquals(1, customer.getVehicles().size());
        assertEquals("Focus", customer.getVehicles().get(0).getModel());
        assertEquals("Ford Focus has been purchased", answer);
    }
}
