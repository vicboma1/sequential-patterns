package gameloop.variabletimestep.utils.processor;

import gameloop.variabletimestep.utils.sprite.Sprite2D;

import java.util.List;

/**
 * Created by vicboma on 01/07/14.
 */
public class Processor {

    public Processor() {
    }


    public void update(Double delta, List<Sprite2D> sprite2DList) {
        sprite2DList.stream().sequential().forEach(x -> x.increaseAngle(delta));
    }
}
