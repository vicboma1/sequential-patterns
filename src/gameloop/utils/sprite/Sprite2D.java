package gameloop.utils.sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by vicboma on 30/06/14.
 */
public class Sprite2D implements Cloneable {
    private int angle;
    private Point position;
    private ImageIcon imageIcon;

    public Sprite2D(String name) {
        imageIcon = new ImageIcon(name);
        position = new Point();
        angle = 0;
    }

    public void x(int x) {
        position.x = x;
    }

    public void y(int y) {
        position.y = y;
    }

    public void position(Point position) {
        this.position = position;
    }

    public int width() {
        return imageIcon.getImage().getWidth(null);
    }

    public int height() {
        return imageIcon.getImage().getHeight(null);
    }

    public void draw(Graphics grafico) {
        grafico.drawImage(imageIcon.getImage(), this.position.x, this.position.y, null);
    }

    public void drawRotate(Graphics grafico) {
        final double _angle = this.angle * Math.PI;
        final double theta = _angle / 180;
        final int x = width() / 2;
        final int y = height() / 2;

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToTranslation(position.x, position.y);
        affineTransform.rotate(theta, x, y);

        ((Graphics2D) grafico).drawImage(imageIcon.getImage(), affineTransform, null);
    }

    public int increaseAngle(Double delta) {
        return (int) ((angle++) * delta);
    }

    public int increaseAngle() {
        return angle++;
    }


    public Sprite2D copy() {
        Sprite2D clone = null;
        try {
            clone = (Sprite2D) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return clone;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
