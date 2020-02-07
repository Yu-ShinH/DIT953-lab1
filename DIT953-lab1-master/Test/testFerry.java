import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Ferry class.
 */
public class testFerry {

    private Ferry f;

    @Before
    public void init() {
        f = new Ferry(3, 100, 30000);
    }

    @Test
    public void loadUnload() {
        car s = new Saab95();
        car v = new Volvo240();

        f.lower();

        f.load(s);
        f.load(v);

        assertTrue(f.unload() == s);
    }
}
