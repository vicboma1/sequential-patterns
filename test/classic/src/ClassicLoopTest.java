package classic.src;

import classic.utils.processor.Processor;
import classic.utils.render.Render;
import classic.utils.windows.Windows;

public class ClassicLoopTest {

    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final ClassicLoop classicLoop = new ClassicLoop(render,processor);
        classicLoop.mainLoop();

    }
}