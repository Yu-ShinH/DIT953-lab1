import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class testMax {
    private Garage g;

    @Before
    public void init() {
        g = new Garage(2);
    }


    @Test
    public void testMax() {
        car c1 = new Volvo240();
        car c2 = new Saab95();
        car c3 = new Volvo240();

        g.addCar(c1);
        g.addCar(c2);
        g.addCar(c3);
        assertTrue(g.nCars() == 2);
    }
}
