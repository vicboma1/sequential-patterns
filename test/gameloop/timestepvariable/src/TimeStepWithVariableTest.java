package gameloop.timestepvariable.src;

import gameloop.timestepvariable.utils.processor.Processor;
import gameloop.timestepvariable.utils.render.Render;
import gameloop.timestepvariable.utils.windows.Windows;

public class TimeStepWithVariableTest {


    public static void main(String args[]) throws InterruptedException {

        final Windows windows = new Windows();
        final Render render = new Render(windows);
        final Processor processor = new Processor();

        final TimeStepWithVariable timeStepWithVariable = new TimeStepWithVariable(render, processor);
        timeStepWithVariable.mainLoop();

    }
}