package gameloop.utils.windows;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by vicboma on 30/06/14.
 */
public class Windows extends Canvas {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    private Frame frame;

    public Windows() {
        frame = new Frame();
        frame.setSize(WIDTH, HEIGHT);
        frame.add(this);
        frame.setBackground(Color.blue);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.requestFocus();
    }

    public Graphics graphics(){
        return this.getGraphics();
    }

    public int width(){
        return this.getWidth();
    }

    public int heigth(){
        return this.getHeight();
    }

}
