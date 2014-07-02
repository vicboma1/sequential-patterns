package gameloop.classic.src;

import doublebuffer.render.Render;
import gameloop.api.Game;
import gameloop.api.Updateable;
import gameloop.utils.sprite.Sprite2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicboma on 30/06/14.
 */
public class ClassicLoop implements Game {

    public static final String RESOURCE_PATH = "./src/gameloop/utils/resource/pop1.png";

    private Render render;
    private Updateable processor;
    private List<Sprite2D> sprite2DList;

    public ClassicLoop(Render render, Updateable processor) {
        this.processor = processor;
        this.render = render;
        prepareSprite();
    }

    private void prepareSprite() {
        this.sprite2DList = new ArrayList<Sprite2D>();
        Sprite2D sprite2D = new Sprite2D(RESOURCE_PATH);

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 18; j++) {
                Sprite2D sprite2DClone = sprite2D.copy();
                sprite2DClone.position(new Point(sprite2DClone.width() * j, sprite2DClone.height() * i));
                sprite2DList.add(sprite2DClone);
            }
        }
    }

    @Override
    public void mainLoop() throws InterruptedException {

        while (true) {
            processInput();
            update();
            draw();
            Thread.sleep(16);
        }
    }

    private void draw() {
        this.render.begin();
        this.render.draw(sprite2DList);
        this.render.end();
    }

    private void update() {
        this.processor.update(sprite2DList);
    }

    private void processInput() {
    }
}
