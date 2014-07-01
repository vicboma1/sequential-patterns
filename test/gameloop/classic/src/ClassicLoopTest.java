package gameloop.classic.src;

import gameloop.classic.utils.processor.Processor;
import gameloop.classic.utils.render.Render;
import gameloop.classic.utils.windows.Windows;

public class ClassicLoopTest {

    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final ClassicLoop classicLoop = new ClassicLoop(render,processor);
        classicLoop.mainLoop();

    }
}