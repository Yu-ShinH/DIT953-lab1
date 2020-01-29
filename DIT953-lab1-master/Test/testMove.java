import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMove {
    car c;

    @Before
    public void init() {
        c = new Saab95();
        c.setCurrentSpeed(10);
    }

    @Test
    public void testMoveCircle() {
        for (int i = 0; i < 6; i++) {
            c.move();
            c.turnLeft();
        }
        assertEquals(0, Math.sqrt((Math.pow(c.getX(), 2)) + Math.pow(c.getY(), 2)), 3);

    }
}
