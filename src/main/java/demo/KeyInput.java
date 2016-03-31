package demo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Aleksandar_Ivanov on 3/30/2016.
 */
public class KeyInput extends KeyAdapter {

    private Player player;

    public KeyInput(Player player) {
        this.player = player;
    }

    public void keyPressed(KeyEvent event) {
        player.keyPressed(event);
    }

    public void keyReleased(KeyEvent event) {
        player.keyReleased(event);
    }
}
