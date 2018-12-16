

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShapeLibraryTest.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 1/31/2018
 */
public class ShapeLibraryTest
{
    /**
     * Default constructor for test class ShapeLibraryTest
     */
    public ShapeLibraryTest()
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
    public void testShapeLibrary() {
        ShapeLibrary lib = new ShapeLibrary();
        assertEquals("circle", lib.getShapes().get(0).getName());
        assertEquals(6, lib.getShapes().size());
        assertEquals("star", lib.getShape("star").getName());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testShapeLibGetNameMethodPreCond() {
        ShapeLibrary lib1 = new ShapeLibrary();
        lib1.getShape(null);
    }
}
