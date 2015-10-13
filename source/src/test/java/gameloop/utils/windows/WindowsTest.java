package gameloop.utils.windows;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * Created by vicboma on 13/10/15.
 */
public class WindowsTest {

    public static final int BORDER = 48;
    private Windows windows;

    @Before
    public void setUp() throws Exception {
        windows = new Windows();
    }

    @After
    public void tearDown() throws Exception {
        windows = null;
    }

    @Test
    public void testGraphics() throws Exception {
        final Graphics graphics = windows.graphics();
        Assert.assertNotNull(graphics);
    }

    @Test
    public void testWidth() throws Exception {
        final int width = windows.width();
        Assert.assertTrue(width <= Windows.WIDTH);
    }

    @Test
    public void testHeigth() throws Exception {
        final int heigth = windows.heigth();
        final int windowHe = Windows.HEIGHT - BORDER;
        Assert.assertTrue(heigth <= windowHe);
    }

}