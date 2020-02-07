import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class testTransporter {
    Transporter<car> t;

    @Before
    public void init() {
        t = new Transporter<>(new ArrayList<car>(), 2, new Mover());
    }

    @Test
    public void testMax() {
        car v = new Volvo240();
        car s = new Saab95();
        car sc = new Scania();

        t.load(v);
        t.load(s);
        t.load(sc);

        assertTrue(t.getN() == 2);

    }
}
