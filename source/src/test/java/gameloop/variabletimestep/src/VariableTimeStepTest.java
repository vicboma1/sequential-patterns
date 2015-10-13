package gameloop.variabletimestep.src;

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
public class VariableTimeStepTest {

    private VariableTimeStep variableTimeStep;
    @Before
    public void setUp() throws Exception {
        final Windows window = new Windows();
        final Render render = new Render(window);
        final Processor processor = new Processor();
        variableTimeStep = new VariableTimeStep(render,processor);
    }

    @After
    public void tearDown() throws Exception {
        variableTimeStep = null;
    }

    @Test(timeout = 22000)
    public void testMainLoop() throws Exception {
        final VariableTimeStep variableTimeStepSpy = spy(variableTimeStep);

        final Thread thread = new Thread(() -> {
            try {
                variableTimeStepSpy.mainLoop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                variableTimeStepSpy.isRunning = false;
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 20000L);

        thread.run();

        verify(variableTimeStepSpy).mainLoop();
    }
}
