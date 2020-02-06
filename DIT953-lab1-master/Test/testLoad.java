import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests load-method.
 */
public class testLoad {
    private Truck t;

    @Before
    public void init() {
        t = new Truck(10, 2000);
        car v = new Volvo240();
        t.lower();
        t.load(v);
    }

    @Test
    public void testPosition() {
        t.raise();
        t.gas(1);
        t.move();
        t.brake(1);
        t.lower();
        car c = t.unLoad();
        double distance = c.distanceFrom(t);
        assertTrue(distance < 2);
    }
}
