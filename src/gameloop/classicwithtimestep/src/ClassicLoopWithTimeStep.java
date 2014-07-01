package gameloop.classicwithtimestep.src;

import gameloop.api.Game;
import gameloop.classicwithtimestep.utils.processor.Processor;
import gameloop.classicwithtimestep.utils.render.Render;
import gameloop.classicwithtimestep.utils.sprite.Sprite2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicboma on 30/06/14.
 */
public class ClassicLoopWithTimeStep implements Game {

    public static final int MILLISECOND = 1000;
    public static final int EXPECTED_FPS = 60;

    private Render render;
    private Processor processor;
    private List<Sprite2D> sprite2DList;
    private int loops;
    private long previousTime;
    private long actualTime;
    private int ticksPerSeconds;


    public ClassicLoopWithTimeStep(Render render, Processor processor) {
        this.processor = processor;
        this.render = render;
        prepareSprite();
    }

    private void prepareSprite() {
        this.sprite2DList = new ArrayList<Sprite2D>();
        Sprite2D sprite2D = new Sprite2D("./src/gameloop/classic/utils/resource/pop1.png");

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

        int ticks = 0;
        final int UPDATES_PER_SECOND = 55;
        final int SKIP_TICKS = MILLISECOND / UPDATES_PER_SECOND;

        previousTime = getCurrentTimeMillis();

        long init = getCurrentTimeMillis();

        while (true) {
            ticks++;
            processInput();

            this.loops = 0;
            this.actualTime = getCurrentTimeMillis();
            while (isUpdate() && isSlowFrames()) {
                update();
                this.previousTime += SKIP_TICKS;
                this.loops++;
            }

            final long actual = getCurrentTimeMillis();
            final long timeElapsed = actual - init;
            if (timeElapsed >= MILLISECOND) {
                init = getCurrentTimeMillis();
                ticksPerSeconds = ticks;
                ticks = 0;
            }

            draw();
        }
    }

    private boolean isSlowFrames() {
        final int MAX_FRAMES = 12;
        return this.loops < MAX_FRAMES;
    }

    private boolean isUpdate() {
        return actualTime > previousTime;
    }

    private Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    private void draw() {
        this.render.begin();
        this.render.draw("PreviousTime: " + previousTime, 0, 12);
        this.render.draw("ActualTime: " + actualTime, 210, 12);
        this.render.draw("Frames Per Second: " + this.ticksPerSeconds + " = " + EXPECTED_FPS + " " + (this.ticksPerSeconds == EXPECTED_FPS), 400, 12);
        this.render.draw(sprite2DList);
        this.render.end();
    }

    private void update() {
        this.processor.update(sprite2DList);
    }

    private void processInput() {

    }
}
