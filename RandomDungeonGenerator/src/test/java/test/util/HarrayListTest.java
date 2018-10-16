package test.util;

import dungeongenerator.util.HarrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

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
    
    @Rule
    public ExpectedException ex = ExpectedException.none();
    
    @Test
    public void toStringTest() {
        Assert.assertTrue("[1, 2]".equals(list.toString()));
    }
    
    @Test
    public void throwsIndexOutofBoundException() throws IndexOutOfBoundsException {
        ex.expect(IndexOutOfBoundsException.class);
        ex.expectMessage("Index: 9, Size 2");
        list.checkRange(9);
    }

}
