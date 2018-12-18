import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class GameDriver extends JPanel {
    private int x = 20; //x and y coordinates of the ball
    private int y = 20;
    private int xa = 100; //Horizontal speed
    private int ya = 50; //Vertical speed
    mainMenu mainMenu = new mainMenu();
//    Building[] list = new Building[5];
//    UFO ufo = new UFO(this, 50, 50, 0, 0);
//    Car car = new Car(this, 0, 825, 5);
/*    public GameDriver() {
        //Randomly create each thing in the list
        list[0] = new Building(300, 25, 3, 10, 0.5);
        list[1] = new Building(450,200, 5, 7, 0.7);
        list[2] = new Building(300,475, 6, 10, 0.5);
        list[3] = new Building(400,800, 4, 8, 0.8);
        list[4] = new Building(550,1025, 3, 5, 0.3);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                ufo.keyReleased(e);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                ufo.keyPressed(e);
            }
        });
        setFocusable(true);
    }*/

    public void paint(Graphics g)
    {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        mainMenu.paint(g2d);

//        for (Building b:list)
//            b.paint(g2d);
//
//        ufo.paint(g2d);
//
//        car.paint(g2d);
    }
    public static void main(String[] args) throws InterruptedException
    {
        JFrame f = new JFrame("Project MAZE (Alpha 1.0)");
        GameDriver gd = new GameDriver();
        f.add(gd);
        f.setSize(766, 890);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true)
        {
            //gd.move(); //Updates the coordinates
            gd.repaint(); //Calls the paint method
            Thread.sleep(10); //Pauses for a moment
        }
    }
}