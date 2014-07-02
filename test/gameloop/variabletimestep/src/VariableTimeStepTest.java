package gameloop.variabletimestep.src;

import doublebuffer.Render;
import gameloop.utils.processor.Processor;
import gameloop.utils.windows.Windows;

public class VariableTimeStepTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final VariableTimeStep variableTimeStep = new VariableTimeStep(render, processor);
        variableTimeStep.mainLoop();

    }
}