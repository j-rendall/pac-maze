import editor.Level;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Move  {

    private BufferedImage img = null;


    public Move()
    {
        try {
            img = ImageIO.read(new File("res\\pacman.png"));
        } catch (IOException e) {
            System.out.println("image not found");
            // hi
        }

        try {
            img = ImageIO.read(new File("res\\Inky.jpg"));
        } catch (IOException e) {
            System.out.println("image not found");
            // hi
        }

        try {
            img = ImageIO.read(new File("res\\Blinky.jpg"));
        } catch (IOException e) {
            System.out.println("image not found");
            // hi
        }

        try {
            img = ImageIO.read(new File("res\\Pinky.jpg"));
        } catch (IOException e) {
            System.out.println("image not found");
            // hi
        }

        try {
            img = ImageIO.read(new File("res\\Clyde.jpg"));
        } catch (IOException e) {
            System.out.println("image not found");
            // hi
        }
    }
}
