import editor.Level;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class levelBuilder  {

    private BufferedImage img = null;


    public levelBuilder()
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




    public static void LevelPaint(Graphics2D g2d)
    {
        int x = 0;
        int y = 50;
        for (int rows =0; rows<=15; rows++) {

            for (int columns = 0; columns <= 15; columns++)
            {
                if (new Level[rows][columns].equals("w"))
                {
                    g2d.fillRect(x,y,50,50);
                    x = x + 50;
                }
                y = y + 50;
                x=0;
            }
        }
    }

}
