import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests gas-method in Scania.
 */
public class testGasScania {
    Scania s;

    @Before
    public void init(){
        s = new Scania();
    }

    /**
     * If the flatbed is raised, using gas should not change the speed.
     */
    @Test
    public void GasWRaisedFlatBed() {
        s.raise(10);
        s.gas(1);
        assertTrue(s.getCurrentSpeed() == 0);
    }
}
