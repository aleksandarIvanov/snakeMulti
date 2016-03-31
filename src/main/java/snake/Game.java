package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandar_Ivanov on 3/31/2016.
 */
public class Game extends JPanel implements ActionListener {
    public static int height = 800;
    public static int width = 800;

    private Timer timer;
    private Snake snake;

    public Game() {
        setFocusable(true);
        timer = new Timer(100, this);
        timer.start();

        snake = new Snake(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        snake.draw(g2d);
        addKeyListener(new KeyInput(snake));
    }

    public void actionPerformed(ActionEvent e) {
        snake.update();
        repaint();
    }
}
