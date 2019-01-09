import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PacmanMove  {

    public int x = 710;
    public int y = 655;
    public static int direction = 4 ;
    public static boolean activity;
    public GameDriver gd;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public static int getDirection(){return direction;}
    public static boolean getActivity() { return activity; }

    public PacmanMove(int x,int y,int direction,Boolean activity,GameDriver gd)
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

    static {
        try {
            pac1 = ImageIO.read(new File("res\\pacman1.png"));
        } catch (IOException e) {
            System.out.println("image not found");
        }

        try {
            pac2 = ImageIO.read(new File("res\\pacman2.png"));
        } catch (IOException e) {
            System.out.println("image not found");
        }

        try {
            pac3 = ImageIO.read(new File("res\\pacman3.png"));
        } catch (IOException e) {
            System.out.println("image not found");
        }

        try {
            pac4 = ImageIO.read(new File("res\\pacman4.png"));
        } catch (IOException e) {
            System.out.println("image not found");
        }
    }

    public static void WPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {

            activity = !activity;
            System.out.println("W PRESSED");
            System.out.println(activity);
            direction = 1;
        }
    }

    public static void WReleased(KeyEvent e) {
        System.out.println("keyReleased=" +
                KeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == KeyEvent.VK_W)
            activity = activity;
    }

    public static void APressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
        {

            activity = !activity;
            System.out.println("A PRESSED");
            System.out.println(activity);
            direction = 2;
        }
    }

    public static void AReleased(KeyEvent e) {
        System.out.println("keyReleased=" +
                KeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == KeyEvent.VK_A)
            activity = activity;
    }


    public static void SPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S)
        {

            activity = !activity;
            System.out.println("S PRESSED");
            System.out.println(activity);
            direction = 3;
        }
    }

    public static void SReleased(KeyEvent e) {
        System.out.println("keyReleased=" +
                KeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == KeyEvent.VK_S)
            activity = activity;
    }
    public static void DPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D)
        {

            activity = !activity;
            System.out.println("D PRESSED");
            System.out.println(activity);
            direction = 4;
        }
    }

    public static void DReleased(KeyEvent e) {
        System.out.println("keyReleased=" +
                KeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == KeyEvent.VK_D)
            activity = activity;
    }

    public void tick() {
        //W Up
        if ((direction == 1) && !activity && this.gd.getLevel().getCell(this.gd.getLevel().getCellIndex(this.x , this.y-5 , 766, 890, 0, 124)) != Level.Cell.WALL)
        {
            y-=5;
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
        else if (direction ==2)
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
            g2d.drawImage(pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac4, 10000, 10000, 40, 40, null);
        }
        else if (direction ==4)
        {
            g2d.drawImage(pac4, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac3, 10000, 10000, 40, 40, null);
            g2d.drawImage(pac1, 10000, 10000, 40, 40, null);
        }
    }
}
