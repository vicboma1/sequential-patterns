package doublebuffer;

import doublebuffer.render.Render;
import gameloop.utils.sprite.Sprite2D;
import gameloop.utils.windows.Windows;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class RenderTest {

    private Render render;

    @org.junit.Before
    public void setUp() throws Exception {
        Windows windows = mock(Windows.class);
        Graphics graphics = mock(Graphics.class);
        final int value = 100;
        when(windows.heigth()).thenReturn(value);
        when(windows.width()).thenReturn(value);
        when(windows.graphics()).thenReturn(graphics);
        render = new Render(windows);
    }

    @org.junit.Test
    public void testBegin() throws Exception {
        Render renderSpy = spy(render);
        renderSpy.begin();
        verify(renderSpy).begin();
    }

    @org.junit.Test
    public void testEnd() throws Exception {
        Render renderSpy = spy(render);
        renderSpy.end();
        verify(renderSpy).end();
    }

    @org.junit.Test
    public void testDraw() throws Exception {
        final List<Sprite2D> sprite2DList = new ArrayList();
        Render renderSpy = spy(render);
        renderSpy.draw(sprite2DList);
        verify(renderSpy).draw(sprite2DList);
    }

    @org.junit.Test
    public void testDraw1() throws Exception {

        String message = "Test";
        final int x = 100;
        final int y = 100;
        Render renderSpy = spy(render);
        renderSpy.begin();
        renderSpy.draw(message, x, y);
        verify(renderSpy).draw(message, x, y);
    }
}