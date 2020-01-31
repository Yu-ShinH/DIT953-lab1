import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for move-method.
 */
public class testMove {
    List<car> cars;

    @Before
    public void init() {
        cars = new ArrayList<>();

        car v = new Volvo240();
        car s = new Saab95();

        cars.add(v);
        cars.add(s);

        for (car c : cars) {
            c.gas(10);
        }
    }

    /**
     * Tests that moving in a circle takes car close to original position.
     */
    @Test
    public void testMoveCircle() {
        boolean close = true;
        for(car c: cars) {
            for (int i = 0; i < 8; i++) {
                c.move();
                c.turnLeft();
            }
            double distance = Math.sqrt((Math.pow(c.getX(), 2)) + Math.pow(c.getY(), 2));
            if (distance > 1) {
                close = false;
                break;
            }
        }
        assertTrue(close);
    }

    /**
     * Tests that moving forward and backwards with the same speed takes car back to the starting point.
     */
    @Test
    public void moveForwardAndBackwards() {
        boolean atStart = true;
        for (car c : cars) {
            c.move();
            c.setDirection(Math.PI);
            c.move();
            double distance = Math.sqrt((Math.pow(c.getX(), 2)) + Math.pow(c.getY(), 2));
            if (distance > 1) {
                atStart = false;
                break;
            }
        }
        assertTrue(atStart);
    }
}
