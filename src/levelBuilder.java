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




    public void paint(Graphics2D g2d) {
        String title = "Pac-Maze";
        Font stringFont1 = new Font( "Arial", Font.ITALIC, 80 );

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,5000, 5000);

        g2d.setFont(stringFont1);
        g2d.setColor(Color.black);
        g2d.drawString(title, 205, 255);
        g2d.setColor(Color.white);
        g2d.drawString(title, 200, 250);
    }

}
