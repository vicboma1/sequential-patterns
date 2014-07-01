package classic.utils.render;

import classic.utils.sprite.Sprite2D;
import classic.utils.windows.Windows;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by vicboma on 30/06/14.
 */
public class Render {

    private Windows windows;
    private BufferedImage bufferedImage;
    private Integer width;
    private Integer heigth;

    public Render(Windows windows) {
        this.windows = windows;
        this.width = this.windows.width();
        this.heigth = this.windows.heigth();
    }


    public void draw(List<Sprite2D> sprite2DList) {
        this.bufferedImage = new BufferedImage(this.width, this.heigth, BufferedImage.TYPE_INT_RGB); //begin

        sprite2DList.stream().sequential().forEach( x -> x.drawRotate(bufferedImage.getGraphics()));

        this.windows.graphics().drawImage(bufferedImage, 0, 0, windows);  //end
    }
}
