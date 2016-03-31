package snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Aleksandar_Ivanov on 3/31/2016.
 */
public class Snake {
    private List<GlobalPosition> body;
    private int direction;

    public Snake(int x, int y) {
        body = new LinkedList<GlobalPosition>(
                Arrays.asList(new GlobalPosition(x, y),
                        new GlobalPosition(x, y + 5),
                        new GlobalPosition(x, y + 10),
                        new GlobalPosition(x, y + 15),
                        new GlobalPosition(x, y + 20),
                        new GlobalPosition(x, y + 25)));
        direction = KeyEvent.VK_RIGHT;
    }

    public void update() {
        switch (direction) {
            case KeyEvent.VK_UP:
                if (body.get(0).y < 1) {
                    body.add(0, new GlobalPosition(body.get(0).x, Game.height - 32));
//                    body.remove(body.size() - 1);
                } else {
                    body.add(0, new GlobalPosition(body.get(0).x, body.get(0).y - 5));
//                    body.remove(body.size() - 1);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (body.get(0).y > Game.height - 27) {
                    body.add(0, new GlobalPosition(body.get(0).x, 1));
//                    body.remove(body.size() - 1);
                } else {
                    body.add(0, new GlobalPosition(body.get(0).x, body.get(0).y + 5));
//                    body.remove(body.size() - 1);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (body.get(0).x < 1) {
                    body.add(0, new GlobalPosition(Game.width - 5, body.get(0).y));
//                    body.remove(body.size() - 1);
                } else {
                    body.add(0, new GlobalPosition(body.get(0).x - 5, body.get(0).y));
//                    body.remove(body.size() - 1);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (body.get(0).x > Game.width) {
                    body.add(0, new GlobalPosition(1, body.get(0).y));
//                    body.remove(body.size() - 1);
                } else {
                    body.add(0, new GlobalPosition(body.get(0).x + 5, body.get(0).y));
//                    body.remove(body.size() - 1);
                }
                break;
        }
        collision();
    }

    public void draw(Graphics2D g) {
        int br = 0;
        for (GlobalPosition part : body) {
            if (br > 3) {
                g.setColor(Color.cyan);
                g.drawRect(part.x, part.y, 5, 5);
            } else {
                g.setColor(Color.cyan);
                g.fillRect(part.x, part.y, 5, 5);
            }
            br++;
        }
    }



    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:
                if (direction != KeyEvent.VK_LEFT) {
                    direction = key;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != KeyEvent.VK_RIGHT) {
                    direction = key;
                }
                break;
            case KeyEvent.VK_UP:
                if (direction != KeyEvent.VK_DOWN) {
                    direction = key;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != KeyEvent.VK_UP) {
                    direction = key;
                }
                break;
            default:
                break;
        }
    }

    public void collision() {
        GlobalPosition head = body.get(0);
        for(GlobalPosition gp : body) {
            if (gp != head && head.x == gp.x && head.y == gp.y) {
                System.out.println("Damn it!");
            }
        }
    }

    public void keyReleased(KeyEvent event) {
//        int key = event.getKeyCode();
//        switch (key) {
//            case KeyEvent.VK_RIGHT:
//                break;
//            case KeyEvent.VK_LEFT:
//                break;
//            case KeyEvent.VK_UP:
//                break;
//            case KeyEvent.VK_DOWN:
//                break;
//            default:
//                break;
//        }
    }

}
