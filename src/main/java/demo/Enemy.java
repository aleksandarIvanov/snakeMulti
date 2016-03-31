package demo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandar_Ivanov on 3/31/2016.
 */
public class Enemy extends GlobalPosition {
    private final String enemyImage = "/enemy.jpg";
    private int speed;

    public Enemy(int x, int y) {
        super(x, y);
        speed = 5;
    }

    public void update() {
        x += speed;
        if (x < 0 ) {
            speed = 5;
        }
        if (x > Game.width - 30) {
            speed = -5;
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(getPlayerImage(), x, y, null);
    }

    public Image getPlayerImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(enemyImage));
        return icon.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 40);
    }

}
