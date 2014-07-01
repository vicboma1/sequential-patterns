package gameloop.classicwithtimestep.src;

import gameloop.classicwithtimestep.utils.processor.Processor;
import gameloop.classicwithtimestep.utils.render.Render;
import gameloop.classicwithtimestep.utils.windows.Windows;

public class ClassicLoopWithTimeStepTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final long frames = 60L;
        final ClassicLoopWithTimeStep classicLoop = new ClassicLoopWithTimeStep(render,processor, frames);
        classicLoop.mainLoop();

    }
}