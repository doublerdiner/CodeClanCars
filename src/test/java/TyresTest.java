import org.junit.Before;
import org.junit.Test;
import vehicles.parts.Tyres;

import static org.junit.Assert.assertEquals;

public class TyresTest {
    private Tyres tyres;
    @Before
    public void setup(){
        tyres = new Tyres("Michelin", "Pilot Sport 4 S");
    }
    @Test
    public void tyresHaveManufacturer(){
        assertEquals("Michelin", tyres.getManufacturer());
    }
    @Test
    public void tyresHaveModel(){
        assertEquals("Pilot Sport 4 S", tyres.getModel());
    }
}
