package gameloop.classicwithfixedtimestep.src;

import doublebuffer.Render;
import gameloop.utils.processor.Processor;
import gameloop.utils.windows.Windows;

public class ClassicLoopWithFixedTimeStepTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final ClassicLoopWithFixedTimeStep ClassicLoopWithFixedTimeStep = new ClassicLoopWithFixedTimeStep(render, processor);
        ClassicLoopWithFixedTimeStep.mainLoop();

    }
}