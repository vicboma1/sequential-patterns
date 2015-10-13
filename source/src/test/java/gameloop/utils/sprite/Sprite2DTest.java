package gameloop.utils.sprite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by vicboma on 13/10/15.
 */
public class Sprite2DTest {

    public static final String RESOURCE_PATH = "./src/gameloop/utils/resource/pop1.png";
    public static final int WIDTH = 71;
    public static final int HEIGHT = 71;

    private Sprite2D sprite2D;

    @Before
    public void setUp() throws Exception {
        sprite2D = new Sprite2D(RESOURCE_PATH);
    }

    @After
    public void tearDown() throws Exception {
        sprite2D = null;
    }

    @Test
    public void testX() throws Exception {
        final Sprite2D sprite2DSpy = spy(sprite2D);
        final int value = 300;
        sprite2DSpy.x(value);
        verify(sprite2DSpy).x(value);
    }

    @Test
    public void testY() throws Exception {
        final Sprite2D sprite2DSpy = spy(sprite2D);
        final int value = 500;
        sprite2DSpy.y(value);
        verify(sprite2DSpy).y(value);
    }

    @Test
    public void testPosition() throws Exception {
        final Sprite2D sprite2DSpy = spy(sprite2D);
        final Point point = new Point(200,450);
        sprite2DSpy.position(point);
        verify(sprite2DSpy).position(point);
    }

    @Test
    public void testWidth() throws Exception {
        final int width = sprite2D.width();
        assertTrue(width == -1);
    }

    @Test
    public void testHeight() throws Exception {
        final int height = sprite2D.height();
        assertTrue(height ==  -1);
    }

    @Test
    public void testDraw() throws Exception {
        final Sprite2D sprite2DSpy = spy(sprite2D);
        final Graphics mock = mock(Graphics.class);
        sprite2DSpy.draw(mock);
        verify(sprite2DSpy).draw(mock);
    }

    @Test
    public void testUpdateAngle() throws Exception {
        final int updateAngle = sprite2D.updateAngle();
        assertTrue(updateAngle == 0);
    }

    @Test
    public void testUpdateAngle1() throws Exception {
        final Double delta = 1.45;
        int updateAngle = sprite2D.updateAngle(delta);
        assertTrue(updateAngle == 0);
        updateAngle = sprite2D.updateAngle(delta);
        assertTrue(updateAngle == 1);
        updateAngle = sprite2D.updateAngle(delta);
        assertTrue(updateAngle == 2);
    }

    @Test
    public void testCopy() throws Exception {
        final Sprite2D copy = sprite2D.copy();
        org.junit.Assert.assertSame(copy.getClass(), sprite2D.getClass());
    }

    @Test
    public void testClone() throws Exception {
        final Sprite2D clone = (Sprite2D)sprite2D.clone();
        org.junit.Assert.assertSame(clone.getClass(), sprite2D.getClass());
    }
}