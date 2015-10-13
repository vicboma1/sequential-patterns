package gameloop.utils.keyBoard;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by vicboma on 12/10/15.
 */
public class KeyStateImplTest {

    private KeyStateImpl keyState;
    private JPanel jPanel;
    @Before
    public void setUp() throws Exception {
        jPanel = new JPanel();
        keyState = new KeyStateImpl(jPanel);
    }

    @After
    public void tearDown() throws Exception {
        keyState = null;
    }

    @Test
    public void testPressed() throws Exception {
        final KeyListener[] keyListeners = jPanel.getKeyListeners();
        IntStream.range(0,keyListeners.length)
                .boxed()
                .forEach(x -> {
                    final KeyListener keyListener = keyListeners[x];
                    mapKeyListener.entrySet().stream().forEach(entry -> {
                        final int key = entry.getKey();
                        final String value = entry.getValue();
                        KeyEvent event = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, key, key, (char) key);
                        keyListener.keyPressed(event);
                        final String pressed = keyState.pressed();
                        Assert.assertEquals(pressed, value);
                    });
                });
    }

    @Test
    public void testKeyReleased() throws Exception {
        final KeyListener[] keyListeners = jPanel.getKeyListeners();
        IntStream.range(0,keyListeners.length)
                .boxed()
                .forEach(x -> {
                    final KeyListener keyListener = keyListeners[x];
                    mapKeyListener.entrySet().stream().forEach(entry -> {
                        final int key = entry.getKey();
                        final String value = entry.getValue();
                        KeyEvent event = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, key, key, (char) key);
                        keyListener.keyReleased(event);
                        final String pressed = keyState.pressed();
                        Assert.assertEquals(pressed, value);
                    });
                });
    }

    @Test
    public void testKeyTyped() throws Exception {
        final KeyListener[] keyListeners = jPanel.getKeyListeners();
        IntStream.range(0,keyListeners.length)
                .boxed()
                .forEach(x -> {
                    final KeyListener keyListener = keyListeners[x];
                    mapKeyListener.entrySet().stream().forEach(entry -> {
                        final int key = entry.getKey();
                        final String value = entry.getValue();
                        KeyEvent event = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, key, key, (char) key);
                        keyListener.keyTyped(event);
                        final String pressed = keyState.pressed();
                        Assert.assertEquals(pressed, value);
                    });
                });
    }

    private final Map<Integer,String> mapKeyListener = new Hashtable(){
        {
            put(KeyEvent.VK_SPACE,"␣");
            put(KeyEvent.VK_A,"A");
            put(KeyEvent.VK_B,"B");
            put(KeyEvent.VK_UP,"↑");
            put(KeyEvent.VK_DOWN,"↓");
            put(KeyEvent.VK_LEFT,"←");
            put(KeyEvent.VK_RIGHT,"→");
            put(KeyEvent.VK_ESCAPE,"⎋");



        }
    };
}