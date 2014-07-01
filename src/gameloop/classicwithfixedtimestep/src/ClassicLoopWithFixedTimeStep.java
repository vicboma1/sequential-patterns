package gameloop.classicwithfixedtimestep.src;

import gameloop.api.Game;
import gameloop.classicwithfixedtimestep.utils.processor.Processor;
import gameloop.classicwithfixedtimestep.utils.render.Render;
import gameloop.classicwithfixedtimestep.utils.sprite.Sprite2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicboma on 30/06/14.
 */
public class ClassicLoopWithFixedTimeStep implements Game {

    public static final String RESOURCE_PATH = "./src/gameloop/resource/pop1.png";
    private static final int UPDATES_PER_SECOND = 55;
    private static final int MILLISECOND = 1000;
    private static final int SKIP_TICKS = MILLISECOND / UPDATES_PER_SECOND;
    private static final int MAX_FRAMES = 12;
    private static final int EXPECTED_FPS = 60;
    private Render render;
    private Processor processor;
    private List<Sprite2D> sprite2DList;
    private int fixedLoop;
    private long previousTime;
    private long actualTime;

    private int ticksPerSecondFPS;
    private int ticksFPS;
    private long initTimeFPS;


    public ClassicLoopWithFixedTimeStep(Render render, Processor processor) {
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
        this.previousTime = getCurrentTimeMillis();
        this.initTimeFPS = this.previousTime;

        while (true) {
            this.ticksFPS++;
            processInput();

            this.fixedLoop = 0;
            this.actualTime = getCurrentTimeMillis();
            while (isUpdate() && isSlowFrames()) {
                update();
                this.previousTime += SKIP_TICKS;
                this.fixedLoop++;
            }

            framePerSecond();
            draw();
        }
    }

    private void update() {
        this.processor.update(sprite2DList);
    }

    private boolean isSlowFrames() {
        return this.fixedLoop < MAX_FRAMES;
    }

    private boolean isUpdate() {
        return actualTime > previousTime;
    }

    private Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    private void framePerSecond() {
        final long actualTimeMillisFPS = getCurrentTimeMillis();
        final long timeElapsedFPS = actualTimeMillisFPS - initTimeFPS;
        if (timeElapsedFPS >= MILLISECOND) {
            this.initTimeFPS = getCurrentTimeMillis();
            this.ticksPerSecondFPS = this.ticksFPS;
            this.ticksFPS = 0;
        }
    }

    private void draw() {
        this.render.begin();
        this.render.draw("PreviousTime: " + previousTime, 0, 12);
        this.render.draw("ActualTime: " + actualTime, 210, 12);
        this.render.draw("Diff: " + (previousTime-actualTime), 400, 12);
        this.render.draw("Frames Per Second: " + this.ticksPerSecondFPS + " = " + EXPECTED_FPS + " " + (this.ticksPerSecondFPS >= EXPECTED_FPS), 450, 12);
        this.render.draw(sprite2DList);
        this.render.end();
    }

    private void processInput() {

    }
}
