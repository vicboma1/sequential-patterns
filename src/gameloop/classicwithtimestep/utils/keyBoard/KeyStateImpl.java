package gameloop.classicwithtimestep.utils.keyBoard;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by vicboma on 30/06/14.
 */
public class KeyStateImpl implements gameloop.classic.utils.keyBoard.KeyState {

    private String key;

    public KeyStateImpl(JPanel panel) {
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                key = KeyEvent.getKeyText(e.getKeyCode());
                System.out.println("key Typed =" + key);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                key = KeyEvent.getKeyText(e.getKeyCode());
                System.out.println("key Pressed =" + key);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key = KeyEvent.getKeyText(e.getKeyCode());
                System.out.println("key Released =" + key);
            }
        });

        panel.setFocusable(true);
    }

    @Override
    public String pressed() {
        return key;
    }
}
