import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pacman  {

    public int x = 710;
    public int y = 655;
    public static int direction = 4 ;
    public static boolean activity;
    public GameDriver gd;


    public int getX() {return x;}
    public int getY() {return x;}
    public static int getDirection(){return direction;}
    public static boolean getActivity() { return activity; }


    public Pacman(int x,int y,int direction,Boolean activity,GameDriver gd)
    {
        this.x = x;
        this.y = y;
        this.direction=direction;
        this.activity=activity;
        this.gd = gd;
    }

    private static BufferedImage pac1 = null;
    private static BufferedImage pac2 = null;
    private static BufferedImage pac3 = null;
    private static BufferedImage pac4 = null;
    private static BufferedImage blinky = null;
    private static BufferedImage clyde = null;
    private static BufferedImage inky = null;
    private static BufferedImage pinky = null;

    public static void WPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            activity = false;
            direction = 1;
            GameDriver.gd.repaint();
        }
    }

    public static void WReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            activity = true;
    }

    public static void APressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            activity = false;
            direction = 2;
            GameDriver.gd.repaint();
        }
    }

    public static void AReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
            activity = true;
    }


    public static void SPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S)
        {

            activity = !activity;
            direction = 3;
            GameDriver.gd.repaint();
        }
    }

    public static void SReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S)
            activity = true;
    }
    public static void DPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            activity = false;
            direction = 4;
            GameDriver.gd.repaint();
        }
    }

    public static void DReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D)
            activity = true;
    }

    public void tick() {
        //W Up
        System.out.println(this.x);
        System.out.println(this.gd.getLevel().getCellIndex(0, 124, 766, 890, this.x , this.y ));
        if ((direction == 1) && !activity && this.gd.getLevel().getCell(this.gd.getLevel().getCellIndex(0, 124, 766, 890, this.x , this.y-5 )) != Level.Cell.WALL)
        {
            y-=5;
        }

        //S DOWN
        if ((direction == 3) && !activity && this.gd.getLevel().getCell(this.gd.getLevel().getCellIndex(0, 124, 766, 890, this.x , this.y+5 )) != Level.Cell.WALL)
        {
            y+=5;
        }

        //A LEFT
        if ((direction == 4) && !activity && this.gd.getLevel().getCell(this.gd.getLevel().getCellIndex(0, 124 , 766, 890, this.x-5 , this.y)) != Level.Cell.WALL)
        {
            x-=5;
        }

        // Right
        if ((direction == 2) && !activity && this.gd.getLevel().getCell(this.gd.getLevel().getCellIndex(0, 124 , 766, 890, this.x+5 , this.y)) != Level.Cell.WALL)
        {
            x+=5;
        }
    }

    public void pacPaint(Graphics2D g2d)
    {
        if (direction ==1)
        {
            g2d.drawImage(pac1, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac3, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac4, 10000, 10000, 40, 40, null);
        }
        else if (direction ==4)
        {
            g2d.drawImage(pac2, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac3, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac4, 10000, 10000, 40, 40, null);
        }
        else if (direction ==3)
        {
            g2d.drawImage(pac3, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac4, 10000, 10000, 40, 40, null);
        }
        else if (direction ==2)
        {
            g2d.drawImage(pac4, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac3, 10000, 10000, 40, 40, null);
        }
    }
    public void ghostPaint(Graphics2D g2d)
    {
        g2d.drawImage(blinky, 50,50,40,40, null);
        g2d.drawImage(clyde, 50,50,40,40, null);
        g2d.drawImage(inky, 50,50,40,40, null);
        g2d.drawImage(pinky, 50,50,40,40, null);
    }
}
