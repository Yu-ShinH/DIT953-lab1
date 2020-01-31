import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests gas-method.
 */
public class testGas {

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
     * Giving gas a parameter larger than 1 should not result in a change in speed.
     */
    @Test
    public void gasALot() {
        boolean notMoving = true;
        for (car c : cars) {
            c.gas(1.1);
            if (c.getCurrentSpeed() != 0) {
                notMoving = false;
                break;
            }
        }
        assertTrue(notMoving);
    }

    /**
     * After using gas with an argument smaller than or equal to 1, the car should be moving.
     */
    @Test
    public void testGas() {
        boolean moving = true;
        for (car c : cars) {
            c.gas(1);

            if (c.getCurrentSpeed() == 0) {
                moving = false;
                break;
            }
        }
        assertTrue(moving);
    }
}
