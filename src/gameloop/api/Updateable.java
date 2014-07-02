package gameloop.api;

import gameloop.utils.sprite.Sprite2D;

import java.util.List;

/**
 * Created by vicboma on 02/07/14.
 */
public interface Updateable {
    abstract void update(List<Sprite2D> sprite2DList);

    abstract void update(Double delta, List<Sprite2D> sprite2DList);
}
