package demo; /**
 * Created by Aleksandar_Ivanov on 3/30/2016.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener {
    public static int height = 500;
    public static int width = 500;

    private final String backgroundPath = "/backg.jpg";

    private Timer timer;
    private Player player;
    private Enemy enemy1;
    private Enemy enemy2;

    public Game() {
        setFocusable(true);
        timer = new Timer(10, this);
        timer.start();

        player = new Player(100, 100);
        enemy1 = new Enemy(200, 200);
        enemy2 = new Enemy(300, 300);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(getBackgroundImage(), 0, 0, this);
        player.draw(g2d);
        enemy1.draw(g2d);
        enemy2.draw(g2d);
        addKeyListener(new KeyInput(player));
//        g2d.fillOval(x, y, 30, 30);
    }

    public void actionPerformed(ActionEvent e) {
        player.update(enemy1, enemy2);
        enemy1.update();
        enemy2.update();
        repaint();
    }

    public Image getBackgroundImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(backgroundPath));
        return icon.getImage();
    }
}
