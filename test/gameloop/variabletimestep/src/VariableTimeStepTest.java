package gameloop.variabletimestep.src;

import gameloop.variabletimestep.utils.processor.Processor;
import gameloop.variabletimestep.utils.render.Render;
import gameloop.variabletimestep.utils.windows.Windows;

public class VariableTimeStepTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final VariableTimeStep variableTimeStep = new VariableTimeStep(render, processor);
        variableTimeStep.mainLoop();

    }
}