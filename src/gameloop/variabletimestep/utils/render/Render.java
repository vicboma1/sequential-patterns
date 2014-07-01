package gameloop.variabletimestep.utils.render;

import gameloop.variabletimestep.utils.sprite.Sprite2D;
import gameloop.variabletimestep.utils.windows.Windows;

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

    public void begin() {
        this.bufferedImage = new BufferedImage(this.width, this.heigth, BufferedImage.TYPE_INT_RGB);
    }

    public void end() {
        this.windows.graphics().drawImage(bufferedImage, 0, 0, windows);
    }

    public void draw(List<Sprite2D> sprite2DList) {
        sprite2DList.stream().sequential().forEach(x -> x.drawRotate(bufferedImage.getGraphics()));
    }

    public void draw(String message, Integer x, Integer y) {
        bufferedImage.getGraphics().drawString(message, x, y);
    }
}
