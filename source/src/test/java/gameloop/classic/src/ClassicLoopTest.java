package gameloop.classic.src;

import doublebuffer.render.Render;
import gameloop.utils.windows.Windows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import updatemethod.processor.Processor;

import java.util.Timer;
import java.util.TimerTask;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma on 12/10/15.
 */
public class ClassicLoopTest {

    private ClassicLoop classicLoop;

    @Before
    public void setUp() throws Exception {
        final Windows window = new Windows();
        final Render render = new Render(window);
        final Processor processor = new Processor();
        classicLoop = new ClassicLoop(render,processor);
    }

    @After
    public void tearDown() throws Exception {
        classicLoop = null;
    }

    @Test(timeout = 22000)
    public void testMainLoop() throws Exception {
        final ClassicLoop classicLoopSpy = spy(classicLoop);

        final Thread thread = new Thread(() -> {
            try {
                classicLoopSpy.mainLoop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                classicLoop.isRunning = false;
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 20000L);

        thread.run();

        verify(classicLoopSpy).mainLoop();
    }
}