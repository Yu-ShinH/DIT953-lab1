import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for turnLeft and turnRight.
 */
public class testTurn {
    List<car> cars;

    @Before
    public void init() {
        cars = new ArrayList<>();

        car v = new Volvo240();
        car s = new Saab95();

        cars.add(v);
        cars.add(s);

        for (car c : cars) {
            c.setDirection(0);
        }
    }

    /**
     * After using turnRight 8 times the direction should be 0.
     */
    @Test
    public void turnCircleRight() {
        boolean rightDirection = true;
        for (car c : cars) {
            for (int i = 0; i < 8; i++) {
                c.turnRight();
            }
            if (c.getDirection() != 0) {
                rightDirection = false;
                break;
            }
        }
        assertTrue(rightDirection);
    }

    /**
     * After using turnLeft 8 times the direction should be 0.
     */
    @Test
    public void turnCircleLeft() {
        boolean rightDirection = true;
        for (car c : cars) {
            for (int i = 0; i < 8; i++) {
                c.turnLeft();
            }
            if (c.getDirection() != 0) {
                rightDirection = false;
                break;
            }
        }
        assertTrue(rightDirection);
    }

}
