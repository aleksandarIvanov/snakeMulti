package snake;

import java.awt.*;

/**
 * Created by Aleksandar_Ivanov on 3/31/2016.
 */
public class GlobalPosition {
    public int x;
    public int y;

    public GlobalPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 5);
    }
}