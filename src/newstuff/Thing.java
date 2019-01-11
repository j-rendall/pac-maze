package newstuff;

import java.awt.*;
import java.awt.event.*;

public abstract class Thing implements MouseListener, KeyListener, MouseMotionListener {
    public abstract void paint(Game gd, Graphics2D g);
    public abstract void tick(Game gd);
    public abstract void check(Game gd, Thing other);

    public void keyTyped(KeyEvent keyEvent) {}
    public void keyPressed(KeyEvent keyEvent) {}
    public void keyReleased(KeyEvent keyEvent) {}
    public void mouseClicked(MouseEvent mouseEvent) {}
    public void mousePressed(MouseEvent mouseEvent) {}
    public void mouseReleased(MouseEvent mouseEvent) {}
    public void mouseEntered(MouseEvent mouseEvent) {}
    public void mouseExited(MouseEvent mouseEvent) {}
    public void mouseDragged(MouseEvent mouseEvent) {}
    public void mouseMoved(MouseEvent mouseEvent) {}
}
