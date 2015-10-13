package gameloop.api;

import gameloop.utils.sprite.Sprite2D;

import java.util.List;

/**
 * Created by vicboma on 02/07/14.
 */
public interface Drawable {
    abstract void draw(List<Sprite2D> sprite2DList);

    abstract void draw(String message, Integer x, Integer y);
}
