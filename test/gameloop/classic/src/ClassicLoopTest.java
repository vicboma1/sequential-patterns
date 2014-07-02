package gameloop.classic.src;

import doublebuffer.render.Render;
import gameloop.utils.windows.Windows;
import updatemethod.processor.Processor;

public class ClassicLoopTest {

    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final ClassicLoop classicLoop = new ClassicLoop(render, processor);
        classicLoop.mainLoop();

    }
}