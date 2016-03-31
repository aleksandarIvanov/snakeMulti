package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Aleksandar_Ivanov on 3/30/2016.
 */
public class Player extends GlobalPosition {


    private int velX;
    private int velY;
    private final String playerImage = "/dog.gif";

    public Player(int x, int y) {
        super(x, y);
        velX = 0;
        velY = 0;
    }

    public void update(Enemy enemy1, Enemy enemy2) {
        x += velX;
        y += velY;

        if (x < 1 ) {
            x = 1;
        }
        if (x > Game.width - 30) {
            x = Game.width - 30;
        }
        if (y < 1) {
            y = 1;
        }
        if (y > Game.height - 30) {
            y = Game.height -30;
        }
        collision(enemy1);
        collision(enemy2);
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:
                velX = 5;
                break;
            case KeyEvent.VK_LEFT:
                velX = -5;
                break;
            case KeyEvent.VK_UP:
                velY = -5;
                break;
            case KeyEvent.VK_DOWN:
                velY = 5;
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:
                velX = 0;
                break;
            case KeyEvent.VK_LEFT:
                velX = 0;
                break;
            case KeyEvent.VK_UP:
                velY = 0;
                break;
            case KeyEvent.VK_DOWN:
                velY = 0;
                break;
            default:
                break;
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(getPlayerImage(), x, y, null);
    }

    public Image getPlayerImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(playerImage));
        return icon.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 40);
    }

    public void collision(Enemy enemy) {
        if (getBounds().intersects(enemy.getBounds())) {
            System.out.println("Ти си черен, аз съм бял");
        }
    }
}
