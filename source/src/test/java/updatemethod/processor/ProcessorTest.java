package updatemethod.processor;

import gameloop.classicwithfixedtimestep.src.ClassicLoopWithFixedTimeStep;
import gameloop.utils.sprite.Sprite2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma on 12/10/15.
 */
public class ProcessorTest {

    private Processor processor;

    @Before
    public void setUp() throws Exception {
        processor = new Processor();
    }

    @After
    public void tearDown() throws Exception {
        processor = null;
    }

    @Test
    public void testUpdateDelta() throws Exception {
        Processor processorSpy = spy(processor);
        final double delta = 1.54355;
        final ArrayList sprite2DList = new ArrayList();
        processorSpy.update(delta, sprite2DList);
        verify(processorSpy).update(delta, sprite2DList);
    }

    @Test
    public void testUpdate() throws Exception {
        Processor processorSpy = spy(processor);
        final ArrayList sprite2DList = new ArrayList();
        prepareSprite(sprite2DList);
        processorSpy.update(sprite2DList);
        verify(processorSpy).update(sprite2DList);
    }

    private void prepareSprite(List<Sprite2D> sprite2DList) {
        Sprite2D sprite2D = new Sprite2D(ClassicLoopWithFixedTimeStep.RESOURCE_PATH);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 18; j++) {
                Sprite2D sprite2DClone = sprite2D.copy();
                sprite2DClone.position(new Point(sprite2DClone.width() * j, sprite2DClone.height() * i + 20));
                sprite2DList.add(sprite2DClone);
            }
        }
    }
}