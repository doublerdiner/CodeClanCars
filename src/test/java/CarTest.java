import org.junit.Before;
import org.junit.Test;
import vehicles.Car;
import vehicles.VehicleTypes;
import vehicles.parts.Engine;
import vehicles.parts.Tyres;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private Car car;
    private Engine engine;
    private Tyres tyres;
    @Before
    public void setup(){
        engine = new Engine("1.5L TDCi diesel", 95, 111);
        tyres = new Tyres("Kumho", "Ecowing ES31");
        car = new Car(VehicleTypes.DIESEL, "Ford", "Focus", engine, tyres, "Blue", 26040);
    }
    @Test
    public void carHasType(){
        assertEquals("Diesel Car", car.getVehicleTypeFormatted());
        assertEquals(false, car.doesVehicleHaveBattery());
        assertEquals(VehicleTypes.DIESEL, car.getVehicleType());
    }
    @Test
    public void carHasMake(){
        assertEquals("Ford", car.getMake());
    }
    @Test
    public void carHasModel(){
        assertEquals("Focus", car.getModel());
    }
    @Test
    public void carHasEngine(){
        assertEquals(engine, car.getEngine());
        assertEquals("1.5L TDCi diesel", car.getEngine().getName());
        assertEquals(95, car.getEngine().getPower());
        assertEquals(111, car.getEngine().getMaxSpeed());
    }
    @Test
    public void carHasTyres(){
        assertEquals(tyres, car.getTyres());
        assertEquals("Kumho", car.getTyres().getManufacturer());
        assertEquals("Ecowing ES31", car.getTyres().getModel());
    }
    @Test
    public void carHasColour(){
        assertEquals("Blue", car.getColour());
    }
    @Test
    public void carHasPrice(){
        assertEquals(26040, car.getPrice());
    }
    @Test
    public void carHasDamage(){
        assertEquals(0, car.getDamage());
    }
    @Test
    public void carDamageCanBeIncreased(){
        car.increaseDamage(8);
        assertEquals(8, car.getDamage());
        assertEquals(26032, car.getPrice());
    }
    @Test
    public void carDamageCanBeRepaired(){
        car.increaseDamage(9);
        car.repairDamage();
        assertEquals(0, car.getDamage());
    }
}
