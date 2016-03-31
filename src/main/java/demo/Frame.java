package demo;

import javax.swing.*;

/**
 * Created by Aleksandar_Ivanov on 3/30/2016.
 */
public class Frame {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Game Frame");
        frame.add(new Game());
        frame.setLocationRelativeTo(null);
        frame.setSize(Game.width, Game.height);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
