import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;


public class GameDriver extends JPanel implements KeyListener, MouseListener {
    private int levelX = 0;
    private int levelY = 100;
    private int levelW = 50;
    private int levelH = 50;
    private int clickX = 0;
    private int clickY = 0;
    mainMenu mainMenu = new mainMenu();

    public int x = 710;
    public int y = 655;
    public static int direction = 4 ;
    public static boolean activity;
    PacmanMove PacmanMove = new PacmanMove(x, y,direction,activity, gd);
    private Level level;

    public Level getLevel() {
        return level;
    }


    public GameDriver(InputStream s) throws Exception {
        this.level = new Level(s);
        addKeyListener(this);
        setFocusable(true);

        this.addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        mainMenu.paint(g2d);

        if (mainMenu.isPlay()) {
            this.level.drawOn(g2d, this.levelX, this.levelY, this.levelW, this.levelH);
            PacmanMove.pacPaint(g2d);
            PacmanMove.ghostPaint(g2d);
        }
        if (mainMenu.isSettings()) {
            mainMenu.settingsPaint(g2d);
        }
        if (mainMenu.isInstructions()) {
            mainMenu.instructionsPaint(g2d);
        }
        if (mainMenu.isExit()) {
            System.exit(10);
        }

        if (mainMenu.isMusic()) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res\\peewee.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch(Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }

        Level.Point point = this.level.getCellIndex(this.levelX, this.levelY, this.levelW, this.levelH, this.clickX, this.clickY);
        //g2d.setColor(Color.GREEN);
        //g2d.drawString(point.toString(), 100, 100);   //draws coordinate of click
    }

    public static GameDriver gd;
    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame("Project MAZE (Alpha 1.0)");
        try {
            int num = 5;

            gd = new GameDriver(GameDriver.class.getResourceAsStream("/level 1.txt"));
            f.add(gd);
            f.setSize(766, 890);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            while (true) {
                //gd.move(); //Updates the coordinates
                if (gd.mainMenu.isPlay()) {
                    gd.PacmanMove.tick();
                }
                gd.repaint(); //Calls the paint method
                Thread.sleep(10); //Pauses for a moment
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        PacmanMove.WPressed(e);
        PacmanMove.APressed(e);
        PacmanMove.SPressed(e);
        PacmanMove.DPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        PacmanMove.WReleased(e);
        PacmanMove.AReleased(e);
        PacmanMove.SReleased(e);
        PacmanMove.DReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mainMenu.mouseClicked(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}