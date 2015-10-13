package gameloop.utils.keyBoard;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by vicboma on 30/06/14.
 */
public class KeyStateImpl implements KeyState {

    private String key;

    public KeyStateImpl(JPanel panel) {
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                key = KeyEvent.getKeyText(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                key = KeyEvent.getKeyText(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key = KeyEvent.getKeyText(e.getKeyCode());
            }
        });

        panel.setFocusable(true);
    }

    @Override
    public String pressed() {
        return key;
    }
}
