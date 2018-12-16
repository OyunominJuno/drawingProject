

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShapeTest.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 1/31/2018
 */
public class ShapeTest
{
    /**
     * Default constructor for test class ShapeTest
     */
    public ShapeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testShapeConstAndAccs() {
        Shape shape1 = new Shape("traingle");
        assertEquals("traingle", shape1.getName());
        shape1.addPoint(new Point(50, 0));
        shape1.addPoint(new Point(0, 100));
        shape1.addPoint(new Point(100, 100));
        assertEquals(3, shape1.getPoints().size());
        assertEquals(3, shape1.getXOfPoints().length);
        assertEquals(3, shape1.getYOfPoints().length);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testShapePreCondName() {
        Shape shape2 = new Shape(null);
    }
}
