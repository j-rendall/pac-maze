import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PacmanMove  {

    private int x;
    private int y;
    private static int direction;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public static boolean activity;
    private GameDriver gd;
    public static boolean getActivity() { return activity; }

    public PacmanMove(int x,int y,int direction,Boolean activity,GameDriver gd)
    {
        this.x = x;
        this.y = y;
        this.direction=direction;
        this.activity=activity;
        this.gd = gd;
    }



    private BufferedImage img = null;

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

    public PacmanMove()
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

        //Level.Point point = this.getLevel().getCellIndex(this.x + 5, this.y +5, 766, 890, 0, 124);


        //W Up
        if ((direction == 1) && !activity)
        {
            y-=5;
        }
        //D Right
        else if (direction == 2 && !activity)
        {
            x+=5;
        }
        //S Down
        else if (direction == 3&& !activity)
        {
            y+=5;
        }
        //A left
        else if (direction == 4 && !activity)
        {
            x-=5;
        }
    }
}
