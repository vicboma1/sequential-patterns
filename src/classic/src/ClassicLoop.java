package classic.src;

import api.Game;
import classic.utils.processor.Processor;
import classic.utils.render.Render;
import classic.utils.sprite.Sprite2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vicboma on 30/06/14.
 */
public class ClassicLoop implements Game {

    private Render render;
    private Processor processor;
    private List<Sprite2D> sprite2DList;

    public ClassicLoop(Render render, Processor processor) {
        this.processor = processor;
        this.render = render;
        prepareSprite();
    }

    private void prepareSprite() {
        this.sprite2DList = new ArrayList<Sprite2D>();
        Sprite2D sprite2D = new Sprite2D("/Users/vicboma/Downloads/pop1.png");

        for(int i=0 ; i<11 ;i++)
        {
            for(int j=0; j<18 ;j++) {
                Sprite2D sprite2DClone = sprite2D.copy();
                sprite2D.point(new Point(sprite2DClone.width() * j , sprite2DClone.height() * i));
                sprite2DList.add(sprite2DClone);
            }
        }
    }

    @Override
    public void mainLoop() throws InterruptedException {

        while (true)
        {
            processInput();
            update();
            draw();
            Thread.sleep(10);
        }
    }

    private void draw() {
        this.render.draw(sprite2DList);
    }

    private void update() {
        this.processor.update(sprite2DList);
    }

    private void processInput() {

    }
}
