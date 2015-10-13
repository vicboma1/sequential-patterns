package gameloop.variabletimestep.src;

import doublebuffer.render.Render;
import gameloop.api.Game;
import gameloop.utils.sprite.Sprite2D;
import updatemethod.processor.Processor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicboma on 30/06/14.
 */
public class VariableTimeStep implements Game {
    public static Boolean isRunning = true;
    public static final String RESOURCE_PATH = "./src/gameloop/utils/resource/pop1.png";
    private static final int EXPECTED_FPS = 60;
    private static final int NANOSECOND = 1000000000;
    private static final int SKIP_TICKS = NANOSECOND / EXPECTED_FPS;

    private Render render;
    private Processor processor;

    private List<Sprite2D> sprite2DList;

    private long previousTime;
    private long actualTime;
    private Double delta;

    private int ticksPerSecondFPS;
    private int ticksFPS;
    private long initTimeFPS;

    private long millis;


    public VariableTimeStep(Render render, Processor processor) {
        this.processor = processor;
        this.render = render;
        this.ticksFPS = 0;
        prepareSprite();
    }

    private void prepareSprite() {
        this.sprite2DList = new ArrayList();
        Sprite2D sprite2D = new Sprite2D(RESOURCE_PATH);

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 18; j++) {
                Sprite2D sprite2DClone = sprite2D.copy();
                sprite2DClone.position(new Point(sprite2DClone.width() * j, sprite2DClone.height() * i + 20));
                sprite2DList.add(sprite2DClone);
            }
        }
    }

    @Override
    public void mainLoop() throws InterruptedException {
        this.ticksFPS = 0;
        this.previousTime = getCurrentTimeNano();
        this.initTimeFPS = previousTime;

        while (isRunning) {

            actualTime = getCurrentTimeNano();
            long updateLength = actualTime - previousTime;
            previousTime = actualTime;
            delta = updateLength / ((double) SKIP_TICKS);

            this.initTimeFPS += updateLength;
            ticksFPS++;
            processInput();
            update(delta);
            framePerSecond();
            draw();

            millis = (previousTime - getCurrentTimeNano() + EXPECTED_FPS) / NANOSECOND;
            Thread.sleep(millis);
        }
    }

    private void update(Double delta) {
        this.processor.update(delta, sprite2DList);
    }

    private Long getCurrentTimeNano() {
        return System.nanoTime();
    }

    private void framePerSecond() {
        if (this.initTimeFPS >= NANOSECOND) {
            this.ticksPerSecondFPS = this.ticksFPS;
            this.initTimeFPS = 0;
            this.ticksFPS = 0;
        }
    }

    private void draw() {
        this.render.begin();
        this.render.draw("PreviousTime: " + previousTime, 0, 12);
        this.render.draw("ActualTime: " + actualTime, 260, 12);
        this.render.draw("Delta: " + this.delta, 510, 12);
        this.render.draw("Frames Per Second: " + this.ticksPerSecondFPS + " = " + EXPECTED_FPS + " " + (this.ticksPerSecondFPS >= EXPECTED_FPS), 700, 12);
        this.render.draw("Thread.sleep: " + this.millis, 920, 12);
        this.render.draw(sprite2DList);
        this.render.end();
    }

    private void processInput() {

    }
}
