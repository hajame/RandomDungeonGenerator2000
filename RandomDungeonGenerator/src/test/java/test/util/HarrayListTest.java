package test.util;

import dungeongenerator.util.HarrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the custom ArrayList implementation
 *
 * @author hajame
 */
public class HarrayListTest {

    private HarrayList<Integer> list;

    public HarrayListTest() {
    }

    @Before
    public void setUp() {
        list = new HarrayList<>();
        list.add(1);
        list.add(2);
    }

    @Test
    public void toStringTest() {
        Assert.assertTrue("[1, 2]".equals(list.toString()));
    }

}
