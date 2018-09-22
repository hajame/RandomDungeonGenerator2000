package test.util;

import dungeongenerator.util.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajame
 */
public class PositionTest {

    private Position position;

    @Before
    public void setUp() {
        this.position = new Position(1, 1);
    }

    @Test
    public void gettersTest() {
        assertEquals(position.x, 1);
        assertEquals(position.y, 1);
    }
}
