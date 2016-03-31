package snake;

import demo.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Aleksandar_Ivanov on 3/31/2016.
 */
public class KeyInput extends KeyAdapter {

    private Snake player;

    public KeyInput(Snake player) {
        this.player = player;
    }

    public void keyPressed(KeyEvent event) {
        player.keyPressed(event);
    }

    public void keyReleased(KeyEvent event) {
        player.keyReleased(event);
    }
}