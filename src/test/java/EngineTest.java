import org.junit.Before;
import org.junit.Test;
import vehicles.parts.Engine;

import static org.junit.Assert.assertEquals;

public class EngineTest {
    private Engine engine;
    @Before
    public void setup(){
        engine = new Engine("1.0L EcoBoost petrol", 100, 114);
    }
    @Test
    public void engineHasName(){
        assertEquals("1.0L EcoBoost petrol", engine.getName());
    }
    @Test
    public void engineHasPower(){
        assertEquals(100, engine.getPower());
    }
    @Test
    public void engineHasMaxSpeed(){
        assertEquals(114, engine.getMaxSpeed());
    }

}
