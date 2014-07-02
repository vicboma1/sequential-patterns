package gameloop.variabletimestep.src;

import doublebuffer.render.Render;
import gameloop.api.Updateable;
import gameloop.utils.windows.Windows;
import updatemethod.processor.Processor;

public class VariableTimeStepTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Updateable processor = new Processor();

        final VariableTimeStep variableTimeStep = new VariableTimeStep(render, processor);
        variableTimeStep.mainLoop();

    }
}