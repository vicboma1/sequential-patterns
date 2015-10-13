package gameloop.utils.windows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

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
        assertNotNull(graphics);
    }

    @Test
    public void testWidth() throws Exception {
        final Windows windowsSpy = spy(windows);
        windowsSpy.width();
        verify(windowsSpy).width();
    }

    @Test
    public void testHeigth() throws Exception {
        final Windows windowsSpy = spy(windows);
        windowsSpy.heigth();
        verify(windowsSpy).heigth();
    }

}