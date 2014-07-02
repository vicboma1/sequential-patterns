package gameloop.classicwithfixedtimestep.src;

import doublebuffer.render.Render;
import gameloop.utils.windows.Windows;
import updatemethod.processor.Processor;

public class ClassicLoopWithFixedTimeStepTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final ClassicLoopWithFixedTimeStep ClassicLoopWithFixedTimeStep = new ClassicLoopWithFixedTimeStep(render, processor);
        ClassicLoopWithFixedTimeStep.mainLoop();

    }
}