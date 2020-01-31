import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests break-method.
 */
public class testBreak {

    List<car> cars;

    @Before
    public void init() {
        cars = new ArrayList<>();

        car v = new Volvo240();
        car s = new Saab95();

        cars.add(v);
        cars.add(s);
    }

    /**
     * Gassing and breaking with the same amount should lead to standing still.
     */
    @Test
    public void gasBreak(){
        boolean notMoving = true;
        for (car c : cars) {
            c.gas(1);
            c.brake(1);

            if (c.getCurrentSpeed() != 0) {
                notMoving = false;
                break;
            }
        }
        assertTrue(notMoving);
    }
}
