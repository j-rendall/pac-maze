import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;

public class RandomStuff extends JPanel {
    private Level level;
    private int levelX = 0;
    private int levelY = 100;
    private int levelW = 50;
    private int levelH = 50;

    private int clickX = 0;
    private int clickY = 0;

    public RandomStuff(InputStream s) throws Exception {
        this.level = new Level(s);
        this.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent mouseEvent) {
                clickX = mouseEvent.getX();
                clickY = mouseEvent.getY();
            }
            @Override public void mousePressed(MouseEvent mouseEvent) {}
            @Override public void mouseReleased(MouseEvent mouseEvent) {}
            @Override public void mouseEntered(MouseEvent mouseEvent) {}
            @Override public void mouseExited(MouseEvent mouseEvent) {}
        });
    }

    //print out mouse position in terms of block
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame("Project MAZE (Alpha 1.0)");
        try {
            int num =5;

            RandomStuff rs = new RandomStuff(RandomStuff.class.getResourceAsStream("/level 1.txt"));
            f.add(rs);
            f.setSize(766, 890);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            while (true) {
                //gd.move(); //Updates the coordinates
                rs.repaint(); //Calls the paint method
                Thread.sleep(10); //Pauses for a moment
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
