package updatemethod.processor;

import gameloop.api.Updateable;
import gameloop.utils.sprite.Sprite2D;

import java.util.List;

/**
 * Created by vicboma on 01/07/14.
 */
public class Processor implements Updateable {

    public Processor() {
    }

    public void update(List<Sprite2D> sprite2DList) {
        sprite2DList.stream().sequential().forEach(x -> x.updateAngle());
    }

    public void update(Double delta, List<Sprite2D> sprite2DList) {
        sprite2DList.stream().sequential().forEach(x -> x.updateAngle(delta));
    }
}
